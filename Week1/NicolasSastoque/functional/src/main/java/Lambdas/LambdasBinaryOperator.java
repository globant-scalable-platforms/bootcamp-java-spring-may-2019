package Lambdas;

import java.util.function.BinaryOperator;

public class LambdasBinaryOperator {

    public static void main(String[] args) {
        System.out.println("Lambdas Binary Operator --->");

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        BinaryOperator<Integer> subtract = (a, b) -> a - b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println("sum 1+1: " + execute(sum, 1, 1));
        System.out.println("subtract 2-2: " + execute(subtract, 2, 2));
        System.out.println("multiply 3*3: " + execute(multiply, 3, 3));
    }

    public static Integer execute(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a, b);
    }
}
