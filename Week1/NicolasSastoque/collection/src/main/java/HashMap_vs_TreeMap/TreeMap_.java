package HashMap_vs_TreeMap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMap_ {

    public static void main(String[] args){
        long start;
        long end;

        System.out.println("Put to TreeMap --->");
        Map<String, Integer> treeMap = new TreeMap<>();

        start = System.nanoTime();
        for(int i = 0; i<10000000; i++){
            treeMap.put(Integer.toString(i), i);
        }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Find in TreeMap --->");
        start = System.nanoTime();
        treeMap.get("1");
        treeMap.get("500000");
        treeMap.get("1000000");
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Remove to TreeMap --->");
        start = System.nanoTime();
        treeMap.remove("1");
        treeMap.remove("500000");
        treeMap.remove("1000000");
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Iterate in TreeMap using entries --->");
        start = System.nanoTime();
        for(Map.Entry<String, Integer> value: treeMap.entrySet()){ }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Iterate in TreeMap using keys --->");
        start = System.nanoTime();
        for(String value: treeMap.keySet()){ }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();

        //
        System.out.println("Iterate in TreeMap using values --->");
        start = System.nanoTime();
        for(Integer value: treeMap.values()){ }
        end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
        System.out.println();
    }
}
