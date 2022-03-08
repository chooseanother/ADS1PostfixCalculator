import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ClientTest {
    private static Client client;

    @BeforeAll
    static void setClient(){
        client = new Client();
    }

    @Test
    void testAdditionMultiplication(){
        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(2));
        tokenList.add(new Operand(1));
        tokenList.add(new Operator(Operation.ADDITION));
        tokenList.add(new Operand(3));
        tokenList.add(new Operator(Operation.MULTIPLICATION));

        assertEquals(9, client.evaluateExpression(tokenList));
    }

    @Test
    void testValidMultiplicationSubtraction(){
        ArrayList<Token> tokenList = new ArrayList<>();
        tokenList.add(new Operand(4));
        tokenList.add(new Operand(7));
        tokenList.add(new Operator(Operation.MULTIPLICATION));
        tokenList.add(new Operand(20));
        tokenList.add(new Operator(Operation.SUBTRACTION));

        assertEquals(8, client.evaluateExpression(tokenList));
    }
}
