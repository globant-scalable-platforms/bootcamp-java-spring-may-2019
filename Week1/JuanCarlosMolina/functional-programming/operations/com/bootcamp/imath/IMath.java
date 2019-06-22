package com.bootcamp.imath;

import java.util.function.BinaryOperator;

public interface IMath {
    Integer execute(BinaryOperator<Integer> op, int a, int b);
}
