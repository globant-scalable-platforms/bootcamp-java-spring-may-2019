package com.globant.bootcamp.list;

import java.util.*;
import java.util.stream.Collectors;

public class ListImplementationTest {

    private final int AMOUNT = 100000;

    public void test(){

        List<Integer> integerSourceList = new Random()
                .ints(AMOUNT)
                .boxed()
                .collect(Collectors.toList());

        ArrayList<Integer> integerArrayList = new ArrayList<>();

        LinkedList<Integer> integerLinkedList = new LinkedList<>();

        System.out.println("------Beginning of List implementations test------");

        System.out.println("Add 100000 elements to ArrayList: "
                + testAdding(integerArrayList, integerSourceList)
                + " ms.");

        System.out.println("Add 100000 elements to LinkedList: "
                + testAdding(integerLinkedList, integerSourceList)
                + " ms.");

        System.out.println("Removing from the middle in ArrayList: "
                + testRemoveFromMiddle(integerArrayList)
                + "µs.");

        System.out.println("Removing from the middle in LinkedList: "
                + testRemoveFromMiddle(integerLinkedList)
                + "µs.");

        System.out.println("Adding to the middle in ArrayList: "
                + testAddToMiddle(integerArrayList)
                + "µs.");

        System.out.println("Adding to the middle in LinkedList: "
                + testAddToMiddle(integerLinkedList)
                + "µs.");

        System.out.println("Iteration over ArrayList: "
                + testIteration(integerArrayList)
                + "ms.");

        System.out.println("Iteration over LinkedList: "
                + testIteration(integerLinkedList)
                + "ms.");

        System.out.println("Sorting ArrayList: "
                + testSorting(integerArrayList)
                + "ms.");

        System.out.println("Sorting LinkedList: "
                + testSorting(integerLinkedList)
                + "ms.");

        System.out.println("------End of List implementations test------");

        System.out.println();

    }

    private long testAdding(List<Integer> implementation, List<Integer> data ){

        long startTime = System.nanoTime();

        for(Integer i : data) implementation.add(i);

        long endTime = System.nanoTime();

        return (endTime - startTime)/100000;
    }

    private long testIteration(List<Integer> implementation){

        long startTime = System.nanoTime();

        for (int i = 0; i < implementation.size(); i++) {
            implementation.get(i);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000;
    }

    private long testRemoveFromMiddle(List<Integer> implementation){

        long startTime = System.nanoTime();

        implementation.remove(implementation.size()/2);

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000;
    }

    private long testAddToMiddle(List<Integer> implementation){

        long startTime = System.nanoTime();

        implementation.add(implementation.size()/2, 1280);

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000;
    }

    private long testSorting(List<Integer> implementation){

        long startTime = System.nanoTime();

        Collections.sort(implementation);

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000;
    }
}
