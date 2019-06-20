package javaCollections;

import java.util.Map;
import java.util.TreeMap;

public class MapIterate {
	

	public static void iterate(Map<Integer, Integer> map) {
		
		long start = System.nanoTime();
		for(Integer value: map.keySet()){
            
        }
	    long end = System.nanoTime();
	    
	    System.out.println("Iterate Map Time (Miliseconds): " + ((end - start)/1000000));
	}

	public static void iterateTree(TreeMap<Integer, Integer> treeMap) {
		
		long start = System.nanoTime();
		for(Integer value: treeMap.keySet()){
            
        }
	    long end = System.nanoTime();
	    
	    System.out.println("Iterate TreeMap Time (Miliseconds): " + ((end - start)/1000000));
	}

 
}
