package lambda;
import java.util.function.BinaryOperator;
public class main {
    private static BinaryOperator<Integer> sum = (a, b) -> a + b;
    private static BinaryOperator<Integer> substract = (a, b) -> a - b;
    private static BinaryOperator<Integer> multiply = (a, b) -> a * b;

    public static void main(String[] args) {

        System.out.println(execute(sum,20,30));
        System.out.println(execute(substract,40,10));
        System.out.println(execute(multiply,90,50));

    }
    public static Integer execute(BinaryOperator<Integer> op, int a, int b) {
        return op.apply(a, b);
    }
}
