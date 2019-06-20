package kataUno;

import java.util.function.BinaryOperator;


public class KataUno {	

	public static Integer execute(BinaryOperator<Integer> op,int a, int b ) {
		return op.apply(a, b);
	}
	
    public static void main(String[] args){
    	  	
    	System.out.println("Kata Uno");                     
        System.out.println("-----------------------------");
       
        BinaryOperator<Integer> sum = (n1, n2) -> n1 + n2;
        System.out.println(KataUno.execute(sum, 1, 2));
        
        BinaryOperator<Integer> subtract = (n1, n2) -> n1 - n2;
        System.out.println(KataUno.execute(subtract, 10, 2));
        
        BinaryOperator<Integer> multiply = (n1, n2) -> n1 * n2;
        System.out.println(KataUno.execute(multiply, 5, 5));
               
    }
}
