import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChallengeB {
    public static void main(String[] args){
        //Creation

        Map<Integer,Integer> hashMap = new HashMap<>();
        Map<Integer,Integer> treeMap = new TreeMap<>();
        
        Random rd = new Random();
        for (int i = 0; i < 10000000; i++) {
            hashMap.put(i,rd.nextInt());
            treeMap.put(i,rd.nextInt());
        }

        long timeHash = 0;
        long timeTree = 0;
        long start = System.nanoTime();

        hashMap.put(10000000, 1);

        long end = System.nanoTime();
        timeHash = end - start;

        System.out.println("HashMap Time Puting (Nanoseconds): " + timeHash);

        start = System.nanoTime();

        treeMap.put(10000000, 1);

        end = System.nanoTime();
        timeTree = end - start;

        System.out.println("TreeMap Time Puting (Nanoseconds): " + timeTree);

        if (timeHash<timeTree) {
            System.out.println("HashMap is better");
        } else {
            System.out.println("TreeMap is better");
        }

        System.out.println("--------------------------------------------- ");
        
        start = System.nanoTime();

        hashMap.get(500);

        end = System.nanoTime();
        timeHash = end - start;

        System.out.println("HashMap Time Finding (Nanoseconds): " + timeHash);

        start = System.nanoTime();

        treeMap.get(500);

        end = System.nanoTime();
        timeTree = end - start;

        System.out.println("TreeMap Time Finding (Nanoseconds): " + timeTree);

        if (timeHash<timeTree) {
            System.out.println("HashMap is better");
        } else {
            System.out.println("TreeMap is better");
        }

        System.out.println("--------------------------------------------- ");

        start = System.nanoTime();

        hashMap.remove(500);

        end = System.nanoTime();
        timeHash = end - start;
        
        System.out.println("HashMap Time Removing (Nanoseconds): " + timeHash);

        start = System.nanoTime();

        treeMap.remove(500);

        end = System.nanoTime();
        timeTree = end - start;
        
        System.out.println("TreeMap Time Removing (Nanoseconds): " + timeTree);

        if (timeHash<timeTree) {
            System.out.println("HashMap is better");
        } else {
            System.out.println("TreeMap is better");
        }

        System.out.println("--------------------------------------------- ");

        start = System.nanoTime();

        hashMap.forEach((k,v) -> System.out.print(""));

        end = System.nanoTime();
        timeHash = end - start;
        
        System.out.println("HashMap Time Iterating (Nanoseconds): " + timeHash);

        start = System.nanoTime();

        treeMap.forEach((k,v) -> System.out.print(""));

        end = System.nanoTime();
        timeTree = end - start;
        
        System.out.println("TreeMap Time Iterating (Nanoseconds): " + timeTree);

        if (timeHash<timeTree) {
            System.out.println("HashMap is better");
        } else {
            System.out.println("TreeMap is better");
        }

        System.out.println("--------------------------------------------- ");

    }
}