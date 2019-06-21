package Katas.TemplateMethodPattern;

/**
 * Class whom implement a basic calculator
 */
public class PositiveBasicCalculator {
    public void printOperation(Integer a, Integer b, PositiveBasicCalculatorOperation operation) throws NegativeArgumentException, NegativeResultException {
        // Pre-action code
        if (a < 0) {
            throw new NegativeArgumentException();
        }

        if (b < 0) {
            throw new NegativeArgumentException();
        }

        // Action
        final Integer result = operation.doOperation(a, b);

        // Post-action code
        if (result < 0) {
            throw new NegativeResultException();
        }

        System.out.println(result);
    }

    public class NegativeArgumentException extends Exception {
    }

    public class NegativeResultException extends Exception {
    }
}
