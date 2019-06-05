package Katas_LambasExpressions;

import java.util.function.BinaryOperator;
import java.util.function.*;

public class sum {
	final static String sum = "SUMA";
	final static String res = "RESTA";
	final static String mul = "MULTIPLICACION";
	public static Integer execute(BinaryOperator<Integer> op, int a, int b) {
		return op.apply(a, b);
	}

	public static void executeFunctions(int a, int b) {
		System.out.println("=== Usando la Interfaz predefinida =====");
		System.out.println("Integer execute(BinaryOperator<Integer> op, int a, int b");
		System.out.println("");
	
		usingLambaFunctions(a, b, sum);
		usingLambaFunctions(a, b, res);
		usingLambaFunctions(a, b, mul);
		System.out.println(" ");
	}

	public static void usingLambaFunctions(int arg1, int arg2, String operator) {
		System.out.print("La "+operator.toLowerCase() + " de " + arg1 + " con " + arg2 + " da ");
		switch (operator) {
		case "SUMA":
			System.out.println(execute(((a, b) -> a + b), arg1, arg2)+".");
			break;
		case "RESTA":
			System.out.println(execute(((a, b) -> a - b), arg1, arg2)+".");
			break;
		case "MULTIPLICACION":
			System.out.println(execute(((a, b) -> a * b), arg1, arg2)+".");
			break;
		default:
			break;
		}

	}

}
