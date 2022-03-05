public class Operator extends Token{
    private final Operation operation;

    public Operator(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void accept(CalculatorVisitor visitor) {
        visitor.visit(this);
    }

    public Operation getOperation(){
        return operation;
    }
}
