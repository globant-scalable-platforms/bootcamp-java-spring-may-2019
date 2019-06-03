package javaCollections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Sort {
	

	public static void sort(List<Integer> list) {
		
		long start = System.nanoTime();
		list.sort(Comparator.naturalOrder());
	    long end = System.nanoTime();
	    
	    System.out.println("Sort List Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void sortLinked(LinkedList<Integer> linkedList) {
		
		long start = System.nanoTime();
		linkedList.sort(Comparator.naturalOrder());
	    long end = System.nanoTime();
	    
	    System.out.println("Sort LinkedList Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
