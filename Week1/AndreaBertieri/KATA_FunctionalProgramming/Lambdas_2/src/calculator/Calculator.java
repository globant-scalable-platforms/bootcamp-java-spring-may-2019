package calculator;

import java.util.function.BinaryOperator;

public class Calculator {
	private Calculator() {System.out.println("Initializing...");};
	
	public Integer execute(BinaryOperator<Integer> op,int a , int b){
        return op.apply(a,b);
    }
	//public void fn1(){System.out.println("Operation 1 called...");};
	//public void fn2(){System.out.println("Operation 2 called...");};
	private void close(){System.out.println("Cleaning up....");};
	
	public static void use(UseCalculator useCalculator) {
	    Calculator calculator = new Calculator();
	    try {
	    	useCalculator.execute(calculator);
	    }finally{
	    	calculator.close();
	    }
	}
}
