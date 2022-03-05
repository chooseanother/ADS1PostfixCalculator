import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class NodeTest {

    public static Node<Token> node;

    @BeforeEach
    void setUp() {
        node = new Node<>();
    }

    @Test
    void testNoData(){
        assertNull(node.getData());
    }

    @Test
    void testNoNext(){
        assertNull(node.getNext());
    }

    @Test
    void testSetData(){
        node.setData(new Operand(5));
        assertEquals(5, ((Operand)node.getData()).getValue());
    }

    @Test
    void testSetNext(){
        node.setNext(new Node<Token>(new Operand(9)));
        assertEquals(9, ((Operand)node.getNext().getData()).getValue());
    }
}
