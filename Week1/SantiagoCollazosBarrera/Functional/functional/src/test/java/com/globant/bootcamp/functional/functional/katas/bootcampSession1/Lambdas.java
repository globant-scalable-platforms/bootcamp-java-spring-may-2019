package com.globant.bootcamp.functional.functional.katas.bootcampSession1;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {


    @Test
    public void createFunction() {
        Function<String,Integer> size = (String a )-> {return a.length();};
        size =  a ->  a.length();

        //System.out.println(size.apply("springBoot"));

        test("prueba",size);
    }

    @Test
    public void createPredicate() {
        Predicate<String> isEmpty = a -> a.isEmpty();

        System.out.println(isEmpty.test("test"));
    }

    public static void test(String message, Function<String,Integer> f){
        System.out.println(f.apply(message));
    }
}
