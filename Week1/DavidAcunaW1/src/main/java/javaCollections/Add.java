package javaCollections;

import java.util.LinkedList;
import java.util.List;

public class Add {
	

	public static void add(List<Integer> list) {
		
		long start = System.nanoTime();
	    list.add(900000);
	    long end = System.nanoTime();
	    
	    System.out.println("Add List Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void addLinked(LinkedList<Integer> linkedList) {
		
		long start = System.nanoTime();
		linkedList.add(900000);
	    long end = System.nanoTime();
	    
	    System.out.println("Add LinkedList Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
