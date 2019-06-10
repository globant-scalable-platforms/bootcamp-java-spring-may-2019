package com.globant.bootcamp.functional.functional.katas.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFunctions {

    public Integer sumList(List<Integer> list){
        Stream<Integer> stream = list.stream();
        return stream.reduce(0, Integer::sum);
    }

    public <T> List<T> deleteDuplicates(List<T> list){
        Stream<T> stream = list.stream();
        return stream.distinct().collect(Collectors.toList());
    }
}
