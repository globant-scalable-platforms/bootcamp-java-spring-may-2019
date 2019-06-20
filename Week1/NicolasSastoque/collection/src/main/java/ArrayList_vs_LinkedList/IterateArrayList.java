package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class IterateArrayList {

    public static void main(String[] args){
        System.out.println("Iterate to ArrayList --->");

        List<Integer> arrayList = populate(new ArrayList<>(), 10000000);

        long start = System.nanoTime();
        for(Integer i : arrayList){ }
        long end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
    }

    private static List<Integer> populate(ArrayList<Integer> objects, int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toCollection(() -> objects));
    }
}
