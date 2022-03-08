import java.util.ArrayList;

public class Client {
    public int evaluateExpression(ArrayList<Token> tokenList){
        CalculatorVisitor calculatorVisitor = new CalculatorVisitor();
        for (Token token : tokenList){
            token.accept(calculatorVisitor);
        }
        try{
            return calculatorVisitor.getResult();
        }catch (MalformedExpressionException exception){
            System.err.println(exception.getMessage());
        }
        return 0;
    }
}
