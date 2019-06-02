package com.bootcamp;

import com.bootcamp.list.ListImplementationTest;
import com.bootcamp.map.MapImplementationTest;

public class Main {

    public static void main(String[] args) {

        ListImplementationTest listTest = new ListImplementationTest();

        MapImplementationTest mapTest = new MapImplementationTest();

        listTest.test();

        mapTest.test();
    }
}
