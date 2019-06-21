package Katas.TemplateMethodPattern;

public class TemplateMethodMain {
    public static void main(String[] args) {
        PositiveBasicCalculator positiveBasicCalculator = new PositiveBasicCalculator();

        try {
            positiveBasicCalculator.printOperation(3, 2, (a, b) -> a + b);
        } catch (PositiveBasicCalculator.NegativeArgumentException | PositiveBasicCalculator.NegativeResultException e) {
            System.out.println("Negative argument");
        }

        try {
            positiveBasicCalculator.printOperation(3, 2, (a, b) -> a - b);
        } catch (PositiveBasicCalculator.NegativeArgumentException | PositiveBasicCalculator.NegativeResultException e) {
            System.out.println("Negative argument");
        }

        try {
            positiveBasicCalculator.printOperation(3, 2, (a, b) -> a * b);
        } catch (PositiveBasicCalculator.NegativeArgumentException | PositiveBasicCalculator.NegativeResultException e) {
            System.out.println("Negative argument");
        }

        try {
            positiveBasicCalculator.printOperation(3, 2, (a, b) -> a * b - a);
        } catch (PositiveBasicCalculator.NegativeArgumentException | PositiveBasicCalculator.NegativeResultException e) {
            System.out.println("Negative argument");
        }

        try {
            positiveBasicCalculator.printOperation(4, 2, (a, b) -> a / b);
        } catch (PositiveBasicCalculator.NegativeArgumentException | PositiveBasicCalculator.NegativeResultException e) {
            System.out.println("Negative argument");
        }

        try {
            positiveBasicCalculator.printOperation(-1, 2, (a, b) -> a + b);
        } catch (PositiveBasicCalculator.NegativeArgumentException | PositiveBasicCalculator.NegativeResultException e) {
            System.out.println("Negative argument");
        }

    }
}
