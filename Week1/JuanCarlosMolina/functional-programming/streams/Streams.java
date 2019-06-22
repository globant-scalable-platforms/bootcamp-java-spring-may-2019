package com.bootcamp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

        List<Integer> integerList = new Random()
                                            .ints(10, 1, 100)
                                            .boxed()
                                            .collect(Collectors.toList());

        System.out.println("List content:");

        System.out.println(integerList);

        System.out.println("Sum of all elements using reduce: " + integerList.stream()
                                                    .reduce(0, (a, b) -> a + b));

        List<Integer> originalValues = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5, 6 , 7, 8);

        System.out.println("Original values: " + originalValues);

        List<Integer> uniquelValues = originalValues.stream().distinct()
                                            .collect(Collectors.toList());

        System.out.println("Unique values: " + uniquelValues);


    }
}
