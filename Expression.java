package calculator;

public class Expression {
    int firstNumber;
    int secondNumber;
    String operator;
    TypeOfExpression type;
    public Expression(int firstNumber, int secondNumber, String operator, TypeOfExpression type){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Expression)) {
            return false;
        }

        Expression expr = (Expression) obj;

        return firstNumber == expr.firstNumber &&
                secondNumber == expr.secondNumber &&
                operator.equals(expr.operator) &&
                type.equals(expr.type);
    }
}