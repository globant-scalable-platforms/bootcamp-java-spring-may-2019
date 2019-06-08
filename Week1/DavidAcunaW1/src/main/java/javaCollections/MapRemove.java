package javaCollections;

import java.util.Map;
import java.util.TreeMap;

public class MapRemove {
	

	public static void remove(Map<Integer, Integer> map) {
		
		long start = System.nanoTime();
	    map.remove(2000);
	    long end = System.nanoTime();
	    
	    System.out.println("Remove Map Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void removeTree(TreeMap<Integer, Integer> treeMap) {
		
		long start = System.nanoTime();
		treeMap.remove(2000);
	    long end = System.nanoTime();
	    
	    System.out.println("Remove TreeMap Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
