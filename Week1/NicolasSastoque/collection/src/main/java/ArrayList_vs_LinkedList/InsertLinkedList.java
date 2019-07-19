package ArrayList_vs_LinkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class InsertLinkedList {

    public static void main(String[] args){
        System.out.println("Insert to LinkedList --->");

        List<Integer> linkedList = populate(new LinkedList<>(), 10000000);

        long start = System.nanoTime();
        //for(int i = 0; i<100; i++){
            int pos = linkedList.size()/2;
            linkedList.add(pos, 1);
        //}
        long end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
    }

    private static List<Integer> populate(LinkedList<Integer> objects, int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toCollection(() -> objects));
    }
}
