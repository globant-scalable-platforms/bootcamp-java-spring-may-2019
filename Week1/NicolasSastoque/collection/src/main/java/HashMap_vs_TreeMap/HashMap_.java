package HashMap_vs_TreeMap;

import java.util.HashMap;
import java.util.Map;

public class HashMap_ {

    public static void main(String[] args){

        long start;
        long end;

        System.out.println("Put to HashMap --->");
        Map<String, Integer> hashMap = new HashMap<>();

        start = System.nanoTime();
        for(int i = 0; i<10000000; i++){
            hashMap.put(Integer.toString(i), i);
        }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Find in HashMap --->");
        start = System.nanoTime();
        hashMap.get("1");
        hashMap.get("500000");
        hashMap.get("1000000");
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Remove to HashMap --->");
        start = System.nanoTime();
        hashMap.remove("1");
        hashMap.remove("500000");
        hashMap.remove("1000000");
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Iterate in HashMap using entries --->");
        start = System.nanoTime();
        for(Map.Entry<String, Integer> value: hashMap.entrySet()){ }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Iterate in HashMap using keys --->");
        start = System.nanoTime();
        for(String value: hashMap.keySet()){ }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Iterate in HashMap using values --->");
        start = System.nanoTime();
        for(Integer value: hashMap.values()){ }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();
    }
}
