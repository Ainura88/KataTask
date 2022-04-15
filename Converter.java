package calculator;

public class Converter {

    public static String arabicToRoman(int num) {
        int i = 0;
        RomanNum[] romanNumbers = RomanNum.values();
        StringBuilder sb = new StringBuilder();
        while ((num > 0) && (i < romanNumbers.length)){
            RomanNum current = romanNumbers[i];
            if (current.getValue() <= num) {
                sb.append(current.name());
                num -= current.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
