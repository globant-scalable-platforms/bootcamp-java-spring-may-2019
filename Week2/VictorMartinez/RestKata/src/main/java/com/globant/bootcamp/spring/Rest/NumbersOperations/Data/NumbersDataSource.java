package com.globant.bootcamp.spring.Rest.NumbersOperations.Data;


import com.globant.bootcamp.spring.Rest.NumbersOperations.Controller.Utils;
import com.globant.bootcamp.spring.Rest.NumbersOperations.Controller.Utils.*;

import java.util.Arrays;
import java.util.OptionalDouble;


public class NumbersDataSource {

    private int[]  input;
    private double average;
    private double count;
    private double max;
    private double sum;


    public NumbersDataSource(String [] input){
        this.input   = Utils.converStringArr2DoubleArr(input);
        this.average = calAverage();
        this.count   = calCount();
        this.max     = calMax();
        this.sum     = calSum();
    }


    public double calAverage(){
        return Arrays.stream(this.input).average().getAsDouble();
    }

    public double calCount(){
        return Arrays.stream(this.input).count();
    }

    public double calMax(){
        return Arrays.stream(this.input).max().getAsInt();
    }
    public double calSum(){
        return Arrays.stream(this.input).sum();
    }

    public double getAverage() {
        return this.average;
    }

    public int[] getInput() {
        return input;
    }

    public void setInput(int[] input) {
        this.input = input;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

}
