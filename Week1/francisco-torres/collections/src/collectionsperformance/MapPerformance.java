package collectionsperformance;

import java.time.*;
import java.util.*;
import java.util.stream.*;

public class MapPerformance {
	private static Map<Integer, String> hashMap = new HashMap<>();
	private static Map<Integer, String> treeMap = new TreeMap<>();
	private static Integer reservedKey = null;  
	
	public MapPerformance(int size) {
		populateMaps(size);
		reservedKey = generateRandomKey(hashMap);
	}
	
	private void populateMaps(int size) {
		Integer integer = null;
		String string = null;
		
		for(int i = 0; i < size; i++) {
			integer = generateRandomKey(hashMap);
			string = generateRandomString();
			
			MapPerformance.hashMap.put(integer, string);
			MapPerformance.treeMap.put(integer, string);
		}
	}
	
	private Integer generateRandomKey(Map<Integer, String> map) {
		Integer integer = null;
		
		do {
			integer = new Random().nextInt();
		} while(map.containsKey(integer));
		
		return integer;
	}
	
	private String generateRandomString() {
		Random random = new Random();
		
		return IntStream.generate(() -> 40 + random.nextInt(70))
						.limit(random.nextInt(70))
						.mapToObj(a -> Character.toString((char)a))
						.collect(Collectors.joining());
	}
	
	public long test(Map<Integer, String> map, String test) {
		Integer key = reservedKey;
		String  value = generateRandomString();
		
		Instant start = Instant.now();
		switch (test) {
		case "Put":
			map.put(key,value);
			break;
		case "FindByKey":
			map.get(key);
			break;
		case "RemoveByKey":
			map.remove(key);
			break;
		case "Iterate":
			map.forEach((k,v) -> {return;});
			break;
		default:
			return -1;
		}
		Instant finish = Instant.now();
		
		return Duration.between(start, finish).toMillis();
	}
	
	public static void main(String[] args) {
		int size = 7_500_000;
		MapPerformance mapTest = null;
		
		System.out.println("# Loading values...");
		mapTest = new MapPerformance(size);
		
		System.out.println("\n# test started -> " + size + " values\n");
		
		System.out.println("# Put an element");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,"Put") + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,"Put") + "ms");
		System.out.println("# Find by key");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,"FindByKey") + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,"FindByKey") + "ms");
		System.out.println("# Remove by key");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,"RemoveByKey") + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,"RemoveByKey") + "ms");
		System.out.println("# Iterate");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,"Iterate") + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,"Iterate") + "ms");
		
		System.out.println("\n# test finished");
	}
}
