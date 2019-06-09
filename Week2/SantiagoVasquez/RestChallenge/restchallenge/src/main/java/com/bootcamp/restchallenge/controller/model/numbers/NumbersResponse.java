package com.bootcamp.restchallenge.controller.model.numbers;

public class NumbersResponse {

    private double average;
    private int count;
    private int max;
    private int min;
    private int sum;

    public NumbersResponse() {
    }

    public NumbersResponse(double average, int count, int max, int min, int sum) {
        this.average = average;
        this.count = count;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
