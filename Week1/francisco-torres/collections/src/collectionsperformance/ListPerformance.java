package collectionsperformance;

import java.time.*;
import java.util.*;
import java.util.Random;
import java.util.stream.*;

public class ListPerformance {
	private static List<String> arrayList = new ArrayList<>();
	private static List<String> linkedList = new LinkedList<>();
	
	public ListPerformance(int size) {
		populateLists(size);
	}
	
	private void populateLists(int size) {
		String string = null;
		
		for(int i = 0; i < size; i++) {
			string = generateRandomString();
			
			ListPerformance.arrayList.add(string);
			ListPerformance.linkedList.add(string);
		}
	}
	
	private String generateRandomString() {
		Random random = new Random();
		
		return IntStream.generate(() -> 40 + random.nextInt(70))
						.limit(10+ random.nextInt(70))
						.mapToObj(a -> Character.toString((char)a))
						.collect(Collectors.joining());
	}
	
	public long test(List<String> list, String test) {
		int indexInTheMiddle = list.size()/2;
		String  value = generateRandomString();
		
		Instant start = Instant.now();
		switch (test) {
		case "InsertMiddle":
			list.add(indexInTheMiddle, value);
			break;
		case "RemoveMiddle":
			list.remove(indexInTheMiddle);
			break;
		case "Add":
			list.add(value);
			break;
		case "Iterate":
			for (String string : list) {}
			break;
		case "Sort":
			Collections.sort(list);
			break;
		default:
			return -1;
		}
		Instant finish = Instant.now();
		
		return Duration.between(start, finish).toMillis();
	}
	
	public static void main(String[] args) {
		int size = 7_500_000;
		ListPerformance listTest = null;
		
		System.out.println("# Loading values...");
		listTest = new ListPerformance(size);
		
		System.out.println("\n# test started -> " + size + " values\n");
		
		System.out.println("# Insert an element in the middle");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList,"InsertMiddle") + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList,"InsertMiddle") + "ms");
		System.out.println("# Remove an element from the middle");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList,"RemoveMiddle") + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, "RemoveMiddle") + "ms");
		System.out.println("# Add an element");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList,"Add") + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, "Add") + "ms");
		System.out.println("# Iterate");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList,"Iterate") + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, "Iterate") + "ms");
		System.out.println("# Sort");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList,"Sort") + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, "Sort") + "ms");
		
		System.out.println("\n# test finished");
	}
}
