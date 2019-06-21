package com.bootcamp.arrayvslinked;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayVsLinked {

	public static void main(String[] args) {
		
		List<Integer> arrays = populate(new ArrayList<Integer>(), 5000000);
		List<Integer> linkeds = populate(new LinkedList<Integer>(), 5000000);
		int remover= 5000000;
		
		System.out.println("WELLCOME: Today an ArrayList and LinkedList will be faced\nWhich will the winner be?");
		
		System.out.println("\nADDING A NEW ELEMENT");
		Categories.use((Categories categories)->{arrays.addAll(arrays); System.out.println("\b  The Array ");});
		Categories.use((Categories categories)->{linkeds.addAll(linkeds);System.out.println("\b The Linked ");});
		
		System.out.println("\nREMOVING AN ELEMENT FROM THE MIDDLE");
		Categories.use((Categories categories)->{arrays.remove(remover); System.out.println("\b The Array ");});
		Categories.use((Categories categories)->{linkeds.remove(remover);System.out.println("\b The Linked ");}); 
		
		System.out.println("\nINSERTING AN ELEMENT FROM THE MIDDLE");
		Categories.use((Categories categories)->{arrays.add(remover,655); System.out.println("\b The Array ");});
		Categories.use((Categories categories)->{linkeds.add(remover,655); System.out.println("\b The Linked ");}); 
		
		System.out.println("\nITERATING THE WHOLE COLLECTION");
		Categories.use((Categories categories)->{for(Integer value: arrays) {} System.out.println("\b The Array ");});
		Categories.use((Categories categories)->{for(Integer value: linkeds) {} System.out.println("\b The Linked ");});
		
		System.out.println("\nSORTING COLLECTION");
		Categories.use((Categories categories)->{arrays.sort(Comparator.naturalOrder()); System.out.println("\b The Array ");});
		Categories.use((Categories categories)->{linkeds.sort(Comparator.naturalOrder()); System.out.println("\b The Linked ");});

	}
	 private static List<Integer> populate(List<Integer> objects, int amount) {
	        return new Random()
	                .ints()
	                .limit(amount)
	                .boxed()
	                .collect(Collectors.toCollection(() -> objects));
	 }
}
