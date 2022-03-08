import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private static LinkedList<Node<Token>> list;

    @BeforeEach
    void setList(){
        list = new LinkedList<>();
    }

    @Test
    void testIsEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test
    void testIsNotEmpty(){
        list.addToFront(new Node<>());
        assertFalse(list.isEmpty());
    }

    @Test
    void testSize(){
        for (int i = 0; i < 5 ; i ++){
            list.addToFront(new Node<>());
        }
        assertEquals(5, list.size());
    }

    @Test
    void testRemoveFirst(){
        for (int i = 0; i < 5 ; i ++){
            list.addToFront(new Node<>(new Operand(i)));
        }
        int value = -1;
        try {
            value = ((Operand)list.removeFirst().getData()).getValue();
        } catch (EmptyListException e){
            System.err.println(e.getMessage());
        }
        assertEquals(4, value);
    }

    @Test
    void testEmptyListException(){
        assertThrows(EmptyListException.class, () -> {
            list.removeFirst();
        });
    }
}
