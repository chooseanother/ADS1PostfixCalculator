public class CalculatorVisitor implements Visitor,Calculator{
    LinkedStack<Token> tokenStack;

    public CalculatorVisitor() {
        tokenStack = new LinkedStack<Token>();
    }

    private void pushOperand(Operand operand){
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException{
        switch (operator.getOperation()){
            case ADDITION:
                int result = ((Operand)tokenStack.pop()).getValue() + ((Operand)tokenStack.pop()).getValue();
                tokenStack.push(new Operand(result));
                break;
            case SUBTRACTION:
                int second = ((Operand)tokenStack.pop()).getValue();
                result = ((Operand)tokenStack.pop()).getValue() - second;
                tokenStack.push(new Operand(result));
                break;
            case MULTIPLICATION:
                result = ((Operand)tokenStack.pop()).getValue() * ((Operand)tokenStack.pop()).getValue();
                tokenStack.push(new Operand(result));
                break;
            case DIVISION:
                second = ((Operand)tokenStack.pop()).getValue();
                if (second == 0){
                    throw new MalformedExpressionException("can not divide by zero");
                }
                result = ((Operand)tokenStack.pop()).getValue() / second;
                tokenStack.push(new Operand(result));
                break;
            default:
                throw new MalformedExpressionException("Symbol not a valid operator");
        }
    }

    @Override
    public int getResult() throws MalformedExpressionException {
        int result = ((Operand)tokenStack.pop()).getValue();
        if (!tokenStack.isEmpty()){
            throw new MalformedExpressionException("too many numbers");
        }
        return result;
    }

    @Override
    public void visit(Operand operand) {
        pushOperand(operand);
    }

    @Override
    public void visit(Operator operator) {
        try{
            performOperation(operator);
        } catch (MalformedExpressionException exception){
            System.err.println(exception.getMessage());
        }
    }
}
