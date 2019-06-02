package com.bootcamp.math;

import java.util.function.BinaryOperator;

public class Calculator {

    //Implementation using functions
    public static Integer sum(int a, int b){
        return a + b;
    }

    public static Integer subtract(int a, int b){
        return a - b;
    }

    public static Integer multiply(int a, int b){
        return a * b;
    }

    //Implementation passing behavior
    public static Integer execute(BinaryOperator<Integer> op, int a, int b){
        return op.apply(a,b);
    }
}
