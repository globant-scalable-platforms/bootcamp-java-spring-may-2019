package lambdas.calculator;

import java.util.Random;
import java.util.function.BinaryOperator;

public class Calculator {
    public static Integer execute(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a,b);
    }

    public static void main(String[] args) {
        int firstNumber = new Random().nextInt(Byte.MAX_VALUE);
        int secondNumber = new Random().nextInt(Byte.MAX_VALUE);

        System.out.println("numbers -> " + firstNumber + ", " + secondNumber);

        System.out.println("---");

        System.out.println("sum -> " + execute((a, b) -> a + b, firstNumber, secondNumber));
        System.out.println("sub -> " + execute((a, b) -> a - b, firstNumber, secondNumber));
        System.out.println("mul -> " + execute((a, b) -> a * b, firstNumber, secondNumber));
    }
}
