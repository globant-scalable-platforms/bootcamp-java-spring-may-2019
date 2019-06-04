/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.functional.functional.katas.streams.Office;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Santiago Collazos Barrera
 */
public class Streams {

    public static void main(String[] args) {
        List<Integer> values = new ArrayList();

        values.add(54);
        values.add(10);
        values.add(29);
        values.add(54);
        values.add(37);
        values.add(60);
        values.add(54);

        System.out.println(values.stream().reduce((a, b) -> a + b));

        values = values.stream().distinct().collect(Collectors.toList());
        System.out.println("_");
        values.stream().forEach(System.out::println);
        System.out.println("_");

    }
}
