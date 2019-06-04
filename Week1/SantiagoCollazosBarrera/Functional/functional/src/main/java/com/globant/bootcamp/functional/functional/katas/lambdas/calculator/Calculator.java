package com.globant.bootcamp.functional.functional.katas.lambdas.calculator;

import java.util.function.BinaryOperator;

public class Calculator {

    public static Integer execute(BinaryOperator<Integer> op,int a , int b){
        return op.apply(a,b);
    }

    public static void main(String[] args) {
    	System.out.println(execute((a,b)-> a+b , 10 , 5)); // Sum
    	System.out.println(execute((a,b)-> a-b , 290 , 467)); // Substract
    	System.out.println(execute((a,b)-> a*b , 192 , 82));  // Multiply  	
    }

}
