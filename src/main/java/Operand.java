public class Operand extends Token {
    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    @Override
    public void accept(CalculatorVisitor visitor) {
        visitor.visit(this);
    }

    public int getValue() {
        return value;
    }
}
