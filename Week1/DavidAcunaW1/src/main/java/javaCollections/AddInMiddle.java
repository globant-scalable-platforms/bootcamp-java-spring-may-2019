package javaCollections;

import java.util.LinkedList;
import java.util.List;

public class AddInMiddle {
	

	public static void add(List<Integer> list) {
		
		long start = System.nanoTime();
	    list.add(list.size()/2, 900000);
	    long end = System.nanoTime();
	    
	    System.out.println("Add in Middle List Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void addLinked(LinkedList<Integer> linkedList) {
		
		long start = System.nanoTime();
		linkedList.add(linkedList.size()/2, 900000);
	    long end = System.nanoTime();
	    
	    System.out.println("Add in Middle LinkedList Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
