/**
 * 
 */
package com.globant.bootcamp.spring.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Juan Pablo
 *
 */
public class Versus {

	/**
	 * @param args
	 */

	private static List<Integer> populateArrayList(ArrayList<Integer> myArrayList, int amount) {
		for (int i = 0; i < amount; i++) {
			myArrayList.add(i);
		}
		return myArrayList;
	}

	private static List<Integer> populateLinkedList(LinkedList<Integer> myLinkedList, int amount) {
		for (int i = 0; i < amount; i++) {
			myLinkedList.add(i);
		}
		return myLinkedList;
	}

	private static Map<Integer, Integer> populateHashMap(HashMap<Integer, Integer> myHashMap, int amount) {
		for (int i = 0; i < amount; i++) {
			myHashMap.put(i, i);
		}
		return myHashMap;
	}

	private static Map<Integer, Integer> populateTreeMap(TreeMap<Integer, Integer> myTreeMap, int amount) {
		for (int i = 0; i < amount; i++) {
			myTreeMap.put(i, i);
		}
		return myTreeMap;
	}

	public static void main(String[] args) {

		int value = 10000000;

		/*
		 * ArrayList
		 */

		// Add elements to ArrayList
		long start = System.nanoTime();
		List<Integer> myArrayList = populateArrayList(new ArrayList<Integer>(), value);
		long end = System.nanoTime();
		System.out.println("Time ArrayList add (Miliseconds): " + ((end - start) / 1000000));

		// Remove element from the middle
		start = System.nanoTime();
		myArrayList.remove(value / 2);
		end = System.nanoTime();
		System.out.println("Time ArrayList remove (Miliseconds): " + ((end - start) / 1000000));

		// Insert a new element in the middle
		start = System.nanoTime();
		myArrayList.add(value / 2, 1);
		end = System.nanoTime();
		System.out.println("Time ArrayList insert (Miliseconds): " + ((end - start) / 1000000));

		// Iterate over the whole collection
		start = System.nanoTime();
		for (int val : myArrayList) {
			;
		}
		end = System.nanoTime();
		System.out.println("Time ArrayList iterate (Miliseconds): " + ((end - start) / 1000000));

		// Sorting the collection
		start = System.nanoTime();
		myArrayList.sort(Comparator.naturalOrder());
		end = System.nanoTime();
		System.out.println("Time ArrayList sort (Miliseconds): " + ((end - start) / 1000000));

		/*
		 * LinkedList
		 */

		// Add elements to LinkedList
		start = System.nanoTime();
		List<Integer> myLinkedList = populateLinkedList(new LinkedList<Integer>(), value);
		end = System.nanoTime();
		System.out.println("Time LinkedList add (Miliseconds): " + ((end - start) / 1000000));

		// Remove element from the middle
		start = System.nanoTime();
		myLinkedList.remove(value / 2);
		end = System.nanoTime();
		System.out.println("Time LinkedList remove (Miliseconds): " + ((end - start) / 1000000));

		// Insert a new element in the middle
		start = System.nanoTime();
		myLinkedList.add(value / 2, 1);
		end = System.nanoTime();
		System.out.println("Time LinkedList insert (Miliseconds): " + ((end - start) / 1000000));

		// Iterate over the whole collection
		start = System.nanoTime();
		for (int val : myLinkedList) {
			;
		}
		end = System.nanoTime();
		System.out.println("Time LinkedList iterate (Miliseconds): " + ((end - start) / 1000000));

		// Sorting the collection
		start = System.nanoTime();
		myLinkedList.sort(Comparator.naturalOrder());
		end = System.nanoTime();
		System.out.println("Time LinkedList sort (Miliseconds): " + ((end - start) / 1000000));

		/*
		 * HashMap
		 */

		// Add
		start = System.nanoTime();
		Map<Integer, Integer> myHashMap = populateHashMap(new HashMap<Integer, Integer>(), value);
		end = System.nanoTime();
		System.out.println("Time HashMap put (Miliseconds): " + ((end - start) / 1000000));

		// Find an element by key
		start = System.nanoTime();
		myHashMap.get(250000);
		end = System.nanoTime();
		System.out.println("Time HashMap find (Miliseconds): " + ((end - start) / 1000000));

		// Remove an element by key
		start = System.nanoTime();
		myHashMap.remove(5000000);
		end = System.nanoTime();
		System.out.println("Time HashMap remove (Miliseconds): " + ((end - start) / 1000000));

		// Iterate over the whole entries
		start = System.nanoTime();
		Iterator it = myHashMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			pair.getKey();
			pair.getValue();
		}
		end = System.nanoTime();
		System.out.println("Time HashMap iterate (Miliseconds): " + ((end - start) / 1000000));

		/*
		 * TreeMap
		 */

		// Add
		start = System.nanoTime();
		Map<Integer, Integer> myTreeMap = populateTreeMap(new TreeMap<Integer, Integer>(), value);
		end = System.nanoTime();
		System.out.println("Time TreeMap put (Miliseconds): " + ((end - start) / 1000000));

		// Find an element by key
		start = System.nanoTime();
		myTreeMap.get(250000);
		end = System.nanoTime();
		System.out.println("Time TreeMap find (Miliseconds): " + ((end - start) / 1000000));

		// Remove an element by key
		start = System.nanoTime();
		myTreeMap.remove(5000000);
		end = System.nanoTime();
		System.out.println("Time TreeMap remove (Miliseconds): " + ((end - start) / 1000000));

		// Iterate over the whole entries
		start = System.nanoTime();
		Iterator it2 = myTreeMap.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry pair = (Map.Entry) it2.next();
			pair.getKey();
			pair.getValue();
		}
		end = System.nanoTime();
		System.out.println("Time TreeMap iterate (Miliseconds): " + ((end - start) / 1000000));

	}

}