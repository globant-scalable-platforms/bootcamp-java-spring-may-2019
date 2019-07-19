package com.globant.bootcamp.functional.functional.katas.lambdas;

import com.globant.bootcamp.functional.functional.katas.lambdas.calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BinaryOperator;

import static org.hamcrest.Matchers.is;

public class CalculatorTest {

	private BinaryOperator<Integer> sum = (a,b) -> (a+b);
    private BinaryOperator<Integer> subtract = (a,b) -> (a-b);
    private BinaryOperator<Integer> multiply = (a,b) -> (a*b);

    @Test
    public void sum() {
        Assert.assertThat(Calculator.execute(sum,3,4),is(7));
    }

    @Test
    public void subtract() {
        Assert.assertThat(Calculator.execute(subtract,4,3),is(1));
    }

    @Test
    public void multiply() {
        Assert.assertThat(Calculator.execute(multiply,4,3),is(12));
    }

}
