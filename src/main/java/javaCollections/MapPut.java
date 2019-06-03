package javaCollections;

import java.util.Map;
import java.util.TreeMap;

public class MapPut {
	

	public static void put(Map<Integer, Integer> map) {
		
		long start = System.nanoTime();
	    map.put(20000000, 20000000);
	    long end = System.nanoTime();
	    
	    System.out.println("Put Map Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void putTree(TreeMap<Integer, Integer> treeMap) {
		
		long start = System.nanoTime();
		treeMap.put(20000000, 20000000);
	    long end = System.nanoTime();
	    
	    System.out.println("Put TreeMap Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
