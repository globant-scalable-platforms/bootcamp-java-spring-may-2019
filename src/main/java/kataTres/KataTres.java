package kataTres;

import java.util.ArrayList;
import java.util.List;

public class KataTres {	
	
    public static void main(String[] args){
    	  	
    	System.out.println("Kata Tres");                     
        System.out.println("-----------------------------");

        List<Integer> list = new ArrayList<Integer>();

        list.add(4);
        list.add(67);
        list.add(3);
        list.add(0);
        list.add(4);
        
        Integer suma = list.stream().reduce(0, Integer::sum);
        System.out.println(suma);
        
        Integer suma_2 = list.stream().reduce(0, (sum, element) -> sum + element);
        System.out.println(suma_2);
               
    }
}
