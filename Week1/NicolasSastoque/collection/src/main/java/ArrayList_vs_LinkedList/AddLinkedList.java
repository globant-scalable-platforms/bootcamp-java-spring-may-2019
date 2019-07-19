package ArrayList_vs_LinkedList;

import java.util.LinkedList;
import java.util.List;

public class AddLinkedList {

    public static void main(String[] args){
        System.out.println("Add to LinkedList --->");

        List<Integer> linkedList = new LinkedList<>();

        long start = System.nanoTime();
        for(int i = 0; i<10000000; i++){
            linkedList.add(i);
        }
        long end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
    }
}
