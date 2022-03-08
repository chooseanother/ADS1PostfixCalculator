import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest {
    private static LinkedStack<Node<Token>> linkedStack;

    @BeforeEach
    void setStack(){
        linkedStack = new LinkedStack<>();
    }

    @Test
    void testIsEmpty(){
        assertTrue(linkedStack.isEmpty());
    }

    @Test
    void testIsNotEmpty(){
        linkedStack.push(new Node<>());
        assertFalse(linkedStack.isEmpty());
    }

    @Test
    void testPop(){
        linkedStack.push(new Node<>(new Operand(1)));
        linkedStack.push(new Node<>(new Operand(2)));
        assertEquals(2,((Operand)linkedStack.pop().getData()).getValue());
    }

    @Test
    void testEmptyStackException() throws EmptyStackException{
        assertThrows(EmptyStackException.class, () -> {
            linkedStack.pop();
        });
    }
}
