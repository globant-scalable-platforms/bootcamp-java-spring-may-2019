package com.bootcamp.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapImplementationTest {

    private final int AMOUNT = 1000000;

    public void test(){

        List<Integer> keysSourceList = new Random()
                .ints(AMOUNT)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> valuesSourceList = new Random()
                .ints(AMOUNT)
                .boxed()
                .collect(Collectors.toList());

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        System.out.println("------Beginning of Map Implementation test------");

        System.out.println("Add " + AMOUNT + " elements to HashMap: "
                + testAdding(hashMap, keysSourceList, valuesSourceList)
                + " ms.");

        System.out.println("Add " + AMOUNT + " elements to TreeMap: "
                + testAdding(treeMap, keysSourceList, valuesSourceList)
                + " ms.");

        Integer key = keysSourceList.get(keysSourceList.size()/2);

        System.out.println("Find element by key in HashMap: "
                + testFindByKey(hashMap, key)
                + " ms.");

        System.out.println("Find element by key in TreeMap: "
                + testFindByKey(treeMap, key)
                + " ms.");

        System.out.println("Remove element by key in HashMap: "
                + testRemoveByKey(hashMap, key)
                + " ms.");

        System.out.println("Remove element by key in TreeMap: "
                + testRemoveByKey(treeMap, key)
                + " ms.");

        System.out.println("Iteration over HashMap: "
                + testIteration(hashMap)
                + "ms.");

        System.out.println("Iteration over TreeMap: "
                + testIteration(treeMap)
                + "ms.");

        System.out.println("------End of Map implementations test------");

        System.out.println();

    }

    private long testAdding(Map<Integer, Integer> implementation, List<Integer> keys, List<Integer> values){

        long startTime = System.nanoTime();

        for (int i = 0; i < keys.size(); i++) {
            implementation.put(keys.get(i), values.get(i));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000;
    }

    private long testFindByKey(Map<Integer, Integer> implementation, Integer key){

        long startTime = System.nanoTime();

        implementation.get(key);

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000;
    }

    private long testRemoveByKey(Map<Integer, Integer> implementation, Integer key){

        long startTime = System.nanoTime();

        implementation.remove(key);

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000;
    }

    private long testIteration(Map<Integer, Integer> implementation){

        long startTime = System.nanoTime();

        for (int i = 0; i < implementation.size(); i++) {
            implementation.get(i);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000;
    }

}
