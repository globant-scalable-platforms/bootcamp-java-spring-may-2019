package collectionsperformance;

import java.time.*;
import java.util.*;
import java.util.Random;
import java.util.stream.*;

public class ListPerformance {
	private static List<String> arrayList = new ArrayList<>();
	private static List<String> linkedList = new LinkedList<>();

	enum test {
		INSERTMIDDLE,
		REMOVEMIDDLE,
		ADD,
		ITERATE,
		SORT
	}

	private ListPerformance(int size) {
		populateLists(size);
	}
	
	private void populateLists(int size) {
		String randomString;
		
		for(int i = 0; i < size; i++) {
			randomString = generateRandomString();
			
			ListPerformance.arrayList.add(randomString);
			ListPerformance.linkedList.add(randomString);
		}
	}
	
	private String generateRandomString() {
		Random random = new Random();
		
		return IntStream.generate(() -> 40 + random.nextInt(70))
						.limit(10+ random.nextInt(70))
						.mapToObj(a -> Character.toString((char)a))
						.collect(Collectors.joining());
	}
	
	private long test(List<String> list, test test) {
		int indexInTheMiddle = list.size()/2;
		String value = generateRandomString();
		
		Instant start = Instant.now();
		switch (test) {
		case INSERTMIDDLE:
			list.add(indexInTheMiddle, value);
			break;
		case REMOVEMIDDLE:
			list.remove(indexInTheMiddle);
			break;
		case ADD:
			list.add(value);
			break;
		case ITERATE:
			for (String string : list) {}
			break;
		case SORT:
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
		ListPerformance listTest;
		
		System.out.println("# Loading values...");
		listTest = new ListPerformance(size);
		
		System.out.println("\n# test started -> " + size + " values\n");
		
		System.out.println("# Insert an element in the middle");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList, test.INSERTMIDDLE) + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, test.INSERTMIDDLE) + "ms");
		System.out.println("# Remove an element from the middle");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList, test.REMOVEMIDDLE) + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, test.REMOVEMIDDLE) + "ms");
		System.out.println("# Add an element");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList, test.ADD) + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, test.ADD) + "ms");
		System.out.println("# Iterate");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList, test.ITERATE) + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, test.ITERATE) + "ms");
		System.out.println("# Sort");
		System.out.println("  Arraylist  -> " + listTest.test(arrayList, test.SORT) + "ms");
		System.out.println("  LinkedList -> " + listTest.test(linkedList, test.SORT) + "ms");
		
		System.out.println("\n# test finished");
	}
}
