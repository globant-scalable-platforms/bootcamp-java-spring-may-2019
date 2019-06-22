package com.bootcamp.math;

import com.bootcamp.imath.IMath;

import java.util.function.BinaryOperator;

public class LambdaCalculator implements IMath {
    @Override
    public Integer execute(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a,b);
    }
}
