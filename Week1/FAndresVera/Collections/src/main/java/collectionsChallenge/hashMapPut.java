package collectionsChallenge;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class hashMapPut {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        long start = System.nanoTime();

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

        long end = System.nanoTime();

        System.out.println("Time: " + ((end - start) / 10));

    }
}
