import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorVisitorTest {
    private static CalculatorVisitor calculatorVisitor;

    @BeforeEach
    void setup(){
        calculatorVisitor = new CalculatorVisitor();
    }

    @Test
    void testMalformedExpressionException(){
        assertThrows(MalformedExpressionException.class, () -> {
            calculatorVisitor.getResult();
        });
    }
}
