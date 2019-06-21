package ArrayList_vs_LinkedList;

import java.util.ArrayList;
import java.util.List;

public class AddArrayList {

    public static void main(String[] args){
        System.out.println("Add to ArrayList --->");

        List<Integer> arrayList = new ArrayList<>();

        long start = System.nanoTime();
        for(int i = 0; i<10000000; i++){
            arrayList.add(i);
        }
        long end = System.nanoTime();

        System.out.println("Time (Miliseconds): " + ((end - start)/1000000));
    }
}
