package com.bootcamp.restchallenge.data;

import java.util.List;

public class NumericControllerImpl implements NumericControllerInterface {
    @Override
    public double average(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).average().getAsDouble();
    }

    @Override
    public int count(List<Integer> numbers) {
        return numbers.size();
    }

    @Override
    public int max(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).max().getAsInt();
    }

    @Override
    public int min(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).min().getAsInt();
    }

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).sum();
    }
}
