package hashMapvsTreeMap;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapvsTreeMap {
	

	public static void main(String[] args) {
		Map<Integer, String> map = populate(new HashMap<Integer, String>(), 6000000);
		Map<Integer, String> treeMap = populate(new TreeMap<Integer, String>(), 5000000);
		
		System.out.println("WELLCOME: Today a Map and a treeMap will be faced\nWhich will the winner be?");
		
		System.out.println("\nPUTTING A NEW ELEMENT");
		Categories.use((Categories categories)->{map.put(5000000,"Cat"); System.out.println("\b The HashMap ");});
		Categories.use((Categories categories)->{treeMap.put(5000000,"Cat");System.out.println("\b The treeMap ");});
		
		System.out.println("\nFINDING AN ELEMENT BY KEY");
		Categories.use((Categories categories)->{map.get(200000); System.out.println("\b The HashMap ");});
		Categories.use((Categories categories)->{treeMap.get(200000);System.out.println("\b The treeMap ");}); 
		
		System.out.println("\nREMOVING AN ELEMENT BY KEY");
		Categories.use((Categories categories)->{map.remove(100000); System.out.println("\b The HashMap ");});
		Categories.use((Categories categories)->{treeMap.remove(100000); System.out.println("\b The treeMap ");}); 
		
		System.out.println("\nITERATING OVER THE WHOLE ENTRIES (Using entries)");
		Categories.use((Categories categories)->{for(Map.Entry<Integer, String> value: map.entrySet()) {} System.out.println("\b The HashMap ");});
		Categories.use((Categories categories)->{for(Map.Entry<Integer, String> value: treeMap.entrySet()) {} System.out.println("\b The treeMap ");});

	}
	
	private static Map<Integer,String> populate(Map<Integer,String> objects, int amount) {
	        for (int i = 0; i < amount; ++i) {
	        	objects.put(i,UUID.randomUUID().toString());}
	        return objects;
    }

}
