package Katas.Lambda;

import java.util.function.BinaryOperator;

public class LambdaMain {
    public static void main(String[] args) {
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        BinaryOperator<Integer> subtract = (a, b) -> a - b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println(execute(sum, 3, 2));
        System.out.println(execute(subtract, 3, 2));
        System.out.println(execute(multiply, 3, 2));
    }

    public static Integer execute(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a, b);
    }
}
