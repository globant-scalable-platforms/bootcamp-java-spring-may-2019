import java.util.*;

class Example{
    public static void main(String[] args){
        int[] numbers = new int[5];
        Arrays.fill(numbers, 5);
        int sum = 0;
        int product = 1;
        int substraction = 0;

        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
            product *= numbers[i];
            substraction -= numbers[i];
        }

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Substraction:" + substraction);
    }
}