package streams.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Operator {
    private static List<Integer> numbers = null;

    private static List<Integer> populateList(List<Integer> objects, int size) {
        return new Random().ints(0,10)
                           .limit(size)
                           .boxed()
                           .collect(Collectors.toCollection(() -> objects));
    }

    public static void main(String[] args) {
        numbers = populateList(new ArrayList<Integer>(),12);

        System.out.print("Sample numbers -> ");
        System.out.print(numbers.stream()
                                .sorted()
                                .collect(Collectors.toList()));

        System.out.print("\nSample sum -> ");
        System.out.print(numbers.stream()
                                .reduce(0,(a,b)->a + b));

        System.out.print("\nUnique values -> ");
        System.out.print(numbers.stream()
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList()));

    }
}
