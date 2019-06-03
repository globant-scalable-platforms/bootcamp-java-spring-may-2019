package functionalChallenge;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BinaryOperator;

import static org.hamcrest.CoreMatchers.is;

public class CalculatorTest {

    private BinaryOperator<Integer> fakeBinaryOperator = (b, a) -> (0);
    private BinaryOperator<Integer> sumBinaryOperator = (b,a) -> (b+a);
    private BinaryOperator<Integer> subtractBinaryOperator = (b,a) -> (b-a);
    private BinaryOperator<Integer> multiplyBinaryOperator = (b,a) -> (b*a);

    @Test
    public void sum() {
        Assert.assertThat(Calculator.execute(sumBinaryOperator,3,4),is(7));
    }

    @Test
    public void subtract() {
        Assert.assertThat(Calculator.execute(subtractBinaryOperator,4,3),is(1));
    }

    @Test
    public void multiply() {
        Assert.assertThat(Calculator.execute(multiplyBinaryOperator,4,3),is(12));
    }
}
