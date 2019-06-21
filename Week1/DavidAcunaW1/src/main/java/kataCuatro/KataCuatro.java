package kataCuatro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class KataCuatro {	
	
    public static void main(String[] args){
    	  	
    	System.out.println("--- Kata Cuatro ---");                     
        System.out.println("-----------------------------");

        List<Integer> list = new ArrayList<Integer>();

        list.add(4);
        list.add(67);
        list.add(3);
        list.add(0);
        list.add(4);
        
        List<Integer> sinDuplicados = list.stream()
        		.distinct()
        		.collect(Collectors.toList());
        
        System.out.println(sinDuplicados);
               
    }
}

