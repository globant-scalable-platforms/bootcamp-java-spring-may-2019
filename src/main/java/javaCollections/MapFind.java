package javaCollections;

import java.util.Map;
import java.util.TreeMap;

public class MapFind {
	

	public static void find(Map<Integer, Integer> map) {
		
		long start = System.nanoTime();
	    map.get(50);
	    long end = System.nanoTime();
	    
	    System.out.println("Find Map Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void findtTree(TreeMap<Integer, Integer> treeMap) {
		
		long start = System.nanoTime();
		treeMap.get(50);
	    long end = System.nanoTime();
	    
	    System.out.println("Find TreeMap Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
