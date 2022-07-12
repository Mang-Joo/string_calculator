package StringCalculator.string_calculator;

public class ArithmeticExpression {

    private final String expression;

    public ArithmeticExpression(String expression) {
        if (expression == null || !expression.matches("^?\\d( ?[*\\-+/] ?\\d)*$")) {
            throw new IllegalArgumentException("잘못된 연산입니다.");
        } else if (expression.matches(".*/\\s*0.*")) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        this.expression = expression;
    }

    public String getExpression() {
        return expression.replaceAll(" ", "");
    }
}
