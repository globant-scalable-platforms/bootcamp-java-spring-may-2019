package collectionsChallenge;

import java.util.Map;
import java.util.TreeMap;

public class treeMapIterate {

    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<>();

        map.put("one", 4);
        map.put("two", 67);
        map.put("three", 3);
        map.put("four", 0);
        map.put("five", 6);

        map.put("six", 46);
        map.put("seven", 27);
        map.put("eight", 356);
        map.put("nine", 76);
        map.put("ten", 63);

        map.put("oneI", 21);
        map.put("twoI", 467);
        map.put("threeI", 874);
        map.put("fourI", 98);
        map.put("fiveI", 36);

        map.put("sixI", 62);
        map.put("sevenI", 648);
        map.put("eightI", 75);
        map.put("nineI", 89);
        map.put("tenI", 32);

        long start = System.nanoTime();

        for(Map.Entry<String, Integer> value: map.entrySet()){
        }

        long end = System.nanoTime();

        System.out.println("Time: " + ((end - start) / 100));

    }
}
