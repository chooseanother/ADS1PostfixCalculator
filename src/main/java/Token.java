public abstract class Token {
    CalculatorVisitor visitor;

    public abstract void accept(CalculatorVisitor visitor);
}
