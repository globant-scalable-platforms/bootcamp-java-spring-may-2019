package calculator;

import java.util.function.BinaryOperator;

public class Main {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> sum=(a,b)->a+b;
		
		Calculator.use((Calculator calculator)->{System.out.println(calculator.execute(sum,3,2));});

	}

}
