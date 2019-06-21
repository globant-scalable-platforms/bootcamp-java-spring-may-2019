package com.globant.lambdas;
import java.util.function.BinaryOperator;

public abstract class BasicOperation {
	
	public static Integer execute(BinaryOperator<Integer> op,int a , int b){
        return op.apply(a,b);
    }
	
}
