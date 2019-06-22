import com.bootcamp.math.Calculator;
import com.bootcamp.math.LambdaCalculator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {


        int firstValue = new Random().nextInt(100);
        int secondValue = new Random().nextInt(100);

        System.out.println("Operations using funtions");

        System.out.println(firstValue + " + " +
                            secondValue + " = " +
                            Calculator.sum(firstValue, secondValue));

        System.out.println(firstValue + " - " +
                secondValue + " = " +
                Calculator.subtract(firstValue, secondValue));

        System.out.println(firstValue + " * " +
                secondValue + " = " +
                Calculator.multiply(firstValue, secondValue));

        System.out.println("Operations passing behavior");

        System.out.println(firstValue + " + " +
                secondValue + " = " +
                Calculator.execute((a, b)->a + b, firstValue, secondValue));

        System.out.println(firstValue + " - " +
                secondValue + " = " +
                Calculator.execute((a, b)->a - b, firstValue, secondValue));

        System.out.println(firstValue + " * " +
                secondValue + " = " +
                Calculator.execute((a, b)->a * b, firstValue, secondValue));

        System.out.println("Operations passing behavior from Template Method pattern");

        System.out.println(firstValue + " + " +
                secondValue + " = " +
                new LambdaCalculator().execute((a, b)->a + b, firstValue, secondValue));

        System.out.println(firstValue + " - " +
                secondValue + " = " +
                new LambdaCalculator().execute((a, b)->a - b, firstValue, secondValue));

        System.out.println(firstValue + " * " +
                secondValue + " = " +
                new LambdaCalculator().execute((a, b)->a * b, firstValue, secondValue));
    }
}
