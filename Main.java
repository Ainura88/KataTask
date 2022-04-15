package calculator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(new InputStreamReader(System.in))) {
            String input;
            String output;
            while (!(input = sc.nextLine().toUpperCase()).equals("ESC")) {
                try {
                    Expression expr = ExpressionParser.parse(input);
                    output = Calculator.calc(expr);
                    System.out.println(output);
                } catch (CustomException e) {
                    System.out.println(e.toString());
                    break;
                }
            }

        }
    }
}

// write your code here


