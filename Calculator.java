package calculator;

public class Calculator {
    /**
     * @param expression Data-Transfer Object для передачи операндов, оператора и типа выражения
     * @return Результат в виде строки
     * @throws CustomException
     */
    public static String calc(calculator.Expression expression) throws calculator.CustomException {
        int result = switch (expression.operator) {
            case "+" -> expression.firstNumber + expression.secondNumber;
            case "-" -> expression.firstNumber - expression.secondNumber;
            case "*" -> expression.firstNumber * expression.secondNumber;
            case "/" -> (int) (expression.firstNumber / expression.secondNumber);
            default -> 0;
        };
        //если арабскими
        if (expression.type == TypeOfExpression.ARABIC) {
            return Integer.toString(result);
        } else if (result <= 0) {
            //без отрицательных в римской системе
            throw new calculator.CustomException("throws Exception //т.к. в римской системе нет отрицательных чисел");
        } else {
            //конвертируем в арабские
            return calculator.Converter.arabicToRoman(result);
        }
    }
}
