package javaCollections;

import java.util.LinkedList;
import java.util.List;

public class IterateCol {
	

	public static void iterate(List<Integer> list) {
		
		long start = System.nanoTime();
	    list.forEach(e -> {});
	    long end = System.nanoTime();
	    
	    System.out.println("Iterate List Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void iterateLinked(LinkedList<Integer> linkedList) {
		
		long start = System.nanoTime();
		linkedList.forEach(e -> {});
	    long end = System.nanoTime();
	    
	    System.out.println("Iterate LinkedList Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
