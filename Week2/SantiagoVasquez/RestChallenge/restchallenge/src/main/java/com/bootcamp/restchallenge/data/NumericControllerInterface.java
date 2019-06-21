package com.bootcamp.restchallenge.data;

import java.util.List;

public interface NumericControllerInterface {
    double average(List<Integer> numbers);

    int count(List<Integer> numbers);

    int max(List<Integer> numbers);

    int min(List<Integer> numbers);

    int sum(List<Integer> numbers);
}
