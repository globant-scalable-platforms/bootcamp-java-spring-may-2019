package com.globant.bootcamp.functional.functional.katas.lambdas;

import com.globant.bootcamp.functional.functional.katas.lambdas.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BinaryOperator;

import static org.hamcrest.Matchers.is;

public class CalculatorTest {

    private BinaryOperator<Integer> sumOperator = (a, b) -> (a + b);
    private BinaryOperator<Integer> subtractOperator = (a, b) -> (a - b);
    private BinaryOperator<Integer> multiplyOperator = (a, b) -> (a * b);

    @Test
    public void sum() {
        Assert.assertThat(Calculator.execute(sumOperator,3,4),is(7));
    }

    @Test
    public void subtract() {
        Assert.assertThat(Calculator.execute(subtractOperator,4,3),is(1));
    }

    @Test
    public void multiply() {
        Assert.assertThat(Calculator.execute(multiplyOperator,4,3),is(12));
    }

}
