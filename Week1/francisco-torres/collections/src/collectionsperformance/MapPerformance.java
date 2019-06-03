package collectionsperformance;

import java.time.*;
import java.util.*;
import java.util.stream.*;

public class MapPerformance {
	private static Map<Integer, String> hashMap = new HashMap<>();
	private static Map<Integer, String> treeMap = new TreeMap<>();
	private static Integer reservedKey = null;  

	enum test {
		PUT,
		FINDBYKEY,
		REMOVEBYKEY,
		ITERATE
	}

	private MapPerformance(int size) {
		populateMaps(size);
		reservedKey = generateRandomKey(hashMap);
	}
	
	private void populateMaps(int size) {
		Integer randomKey;
		String randomString;
		
		for(int i = 0; i < size; i++) {
			randomKey = generateRandomKey(hashMap);
			randomString = generateRandomString();
			
			MapPerformance.hashMap.put(randomKey, randomString);
			MapPerformance.treeMap.put(randomKey, randomString);
		}
	}
	
	private Integer generateRandomKey(Map<Integer, String> map) {
		Integer randomKey;
		
		do {
			randomKey = new Random().nextInt();
		} while(map.containsKey(randomKey));
		
		return randomKey;
	}
	
	private String generateRandomString() {
		Random random = new Random();
		
		return IntStream.generate(() -> 40 + random.nextInt(70))
						.limit(random.nextInt(70))
						.mapToObj(a -> Character.toString((char)a))
						.collect(Collectors.joining());
	}
	
	private long test(Map<Integer, String> map, test test) {
		Integer key = reservedKey;
		String  value = generateRandomString();
		
		Instant start = Instant.now();
		switch (test) {
		case PUT:
			map.put(key,value);
			break;
		case FINDBYKEY:
			map.get(key);
			break;
		case REMOVEBYKEY:
			map.remove(key);
			break;
		case ITERATE:
			map.forEach((k,v) -> {});
			break;
		default:
			return -1;
		}
		Instant finish = Instant.now();
		
		return Duration.between(start, finish).toMillis();
	}
	
	public static void main(String[] args) {
		int size = 7_500_000;
		MapPerformance mapTest;
		
		System.out.println("# Loading values...");
		mapTest = new MapPerformance(size);
		
		System.out.println("\n# test started -> " + size + " values\n");
		
		System.out.println("# Put an element");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,test.PUT) + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,test.PUT) + "ms");
		System.out.println("# Find by key");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,test.FINDBYKEY) + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,test.FINDBYKEY) + "ms");
		System.out.println("# Remove by key");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,test.REMOVEBYKEY) + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,test.REMOVEBYKEY) + "ms");
		System.out.println("# Iterate");
		System.out.println("  HashMap -> " + mapTest.test(hashMap,test.ITERATE) + "ms");
		System.out.println("  TreeMap -> " + mapTest.test(treeMap,test.ITERATE) + "ms");
		
		System.out.println("\n# test finished");
	}
}
