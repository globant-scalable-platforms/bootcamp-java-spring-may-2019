package javaCollections;

import java.util.LinkedList;
import java.util.List;

public class RemoveFromMiddle {
	

	public static void remove(List<Integer> list) {
		
		long start = System.nanoTime();
	    list.remove(list.size()/2);
	    long end = System.nanoTime();
	    
	    System.out.println("Remove from Middle List Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void removeLinked(LinkedList<Integer> linkedList) {
		
		long start = System.nanoTime();
		linkedList.remove(linkedList.size()/2);
	    long end = System.nanoTime();
	    
	    System.out.println("Remove from Middle LinkedList Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
