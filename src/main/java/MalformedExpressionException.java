public class MalformedExpressionException extends Exception {
    public MalformedExpressionException(String message) {
        super("Expression is not valid: "+message);
    }
}
