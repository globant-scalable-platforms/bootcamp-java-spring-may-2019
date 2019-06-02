package com.bootcamp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectingItems {

    public static void main(String[] args) {

        List<String> firstTable = Arrays.asList("Eraser", "Pen", "Book", "Phone", "Laptop", "Pencil");

        List<String> secondTable = Arrays.asList("Pen", "Agenda", "Laptop", "Magazine", "Mirror", "Gloves");

        List<String> thirdTable = Arrays.asList("Notebook", "News Paper", "Calculator", "Phone");

        Stream<List<String>> allItems = Stream.of(firstTable, secondTable, thirdTable);

        System.out.println("----------Full list of elements----------");

        allItems.flatMap(l -> l.stream()).forEach(System.out::println);

        allItems = Stream.of(firstTable, secondTable, thirdTable);

        System.out.println("----------Partial list of elements----------");

        allItems.flatMap(l -> l.stream()).limit(7).forEach(System.out::println);

    }
}
