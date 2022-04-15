package calculator;

import java.util.Arrays;
import java.util.List;


public class ExpressionParser {
    private static final List<String> operators = Arrays.asList("+", "-", "*", "/");
    private static final List<String> Arabic = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    private static final List<String> Roman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    public static Expression parse(String input) throws CustomException {
        String[] form = input.split(" ");
        Expression expression;

        if (form.length != 3){
            throw new CustomException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (!operators.contains(form[1])) {
            throw new CustomException("throws Exception //т.к. в римской системе нет отрицательных чисел");
        } else if ((!Arabic.contains(form[0]) && !Roman.contains(form[0])) ||
                (!Arabic.contains(form[2]) && !Roman.contains(form[2]))){
            throw new CustomException("throws Exception// т.к. вне диапазона допустимых значений");
        } else if ((Arabic.contains(form[0]) && Roman.contains(form[2])) ||
                (Arabic.contains(form[2]) && Roman.contains(form[0]))){
            //операнды разного типа
            throw new CustomException("throws Exception //т.к. используются одновременно разные системы счисления");
        } else if (Arabic.contains(form[0])){
            //выражение из арабских цифр
            expression = new Expression(Arabic.indexOf(form[0]) + 1,
                    Arabic.indexOf(form[2]) + 1, form[1], TypeOfExpression.ARABIC);
        } else {
            /* Значит из римских */
            expression = new Expression(Roman.indexOf(form[0]) + 1,
                    Roman.indexOf(form[2]) + 1, form[1], TypeOfExpression.ROMAN);
        }
        return expression;
    }
}