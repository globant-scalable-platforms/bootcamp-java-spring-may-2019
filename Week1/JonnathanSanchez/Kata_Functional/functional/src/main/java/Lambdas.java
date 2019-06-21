import java.util.function.BinaryOperator;

public class Lambdas {

    public static void main(String[] args) {

        //Calculator with Lambdas
        System.out.println("Lambda Calculator");
        System.out.println("Sum: " + execute((a, b) -> a + b, 5, 4));
        System.out.println("Subtract,: " + execute((a, b) -> a - b, 5, 4));
        System.out.println("Multiply: " + execute((a, b) -> a * b, 5, 4));

    }


    public static Integer execute(BinaryOperator<Integer> op,int a , int b){
        return op.apply(a,b);
    }
}

