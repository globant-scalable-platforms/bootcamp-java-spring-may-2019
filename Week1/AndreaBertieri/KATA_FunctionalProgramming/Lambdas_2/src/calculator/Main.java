package calculator;

import java.util.function.BinaryOperator;

public class Main {

	public static void main(String[] args) {
		//Code without Lambdas
		/*Calculator.use(new UseCalculator() {
			@Override
			public void execute(Calculator calculator) {
				calculator.fn1();
				calculator.fn2();
			}
		});*/
		
		//Code With Lambdas
		BinaryOperator<Integer> sum=(a,b)->a+b;
		
		Calculator.use((Calculator calculator)->{System.out.println(calculator.execute(sum,3,2));});
			//calculator.fn1(); calculator.fn2();});
		
		

	}

}
