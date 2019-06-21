package com.globant.lambdas;
import java.lang.Integer;
import java.util.function.BinaryOperator;

public class Calculator {

	public static void main(String[] args) {
		BinaryOperator<Integer> sum=(a,b)->a+b;
		BinaryOperator<Integer> subtract=(a,b)->a-b;
		BinaryOperator<Integer> multiply=(a,b)->a*b;
		
		System.out.println(BasicOperation.execute(sum,4,7));
		System.out.println(BasicOperation.execute(subtract,4,7));
		System.out.println(BasicOperation.execute(multiply,4,7));
	}

}
