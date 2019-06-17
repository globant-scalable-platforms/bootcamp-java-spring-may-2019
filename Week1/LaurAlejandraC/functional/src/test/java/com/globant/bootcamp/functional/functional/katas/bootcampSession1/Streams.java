package com.globant.bootcamp.functional.functional.katas.bootcampSession1;

import org.junit.Test;

import java.util.Arrays;

public class Streams {


    @Test
    public void stream1() {

        System.out.println(Arrays.asList("juan","pedro","juan","trump").stream().distinct().map(a -> a+"yahoo").count());
        Arrays.asList("juan","pedro","juan","trump").stream()
                .distinct().map(a -> a+"yahoo").forEach(System.out::println );
    }
}
