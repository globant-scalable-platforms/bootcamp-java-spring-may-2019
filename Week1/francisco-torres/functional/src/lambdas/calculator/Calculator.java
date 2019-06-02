package lambdas.calculator;

import java.util.Random;
import java.util.function.BinaryOperator;

public class Calculator {
    private static int firstNumber = 0;
    private static int secondNumber = 0;

    public static Integer execute(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a,b);
    }

    public static void main(String[] args) {
        firstNumber = new Random().nextInt(Byte.MAX_VALUE);
        secondNumber = new Random().nextInt(Byte.MAX_VALUE);

        System.out.println("numbers -> " + firstNumber + ", " + secondNumber);

        System.out.println("---");

        System.out.println("sum -> " + execute((a, b) -> {return a + b;},firstNumber,secondNumber));
        System.out.println("sub -> " + execute((a, b) -> {return a - b;},firstNumber,secondNumber));
        System.out.println("mul -> " + execute((a, b) -> {return a * b;},firstNumber,secondNumber));
    }
}
