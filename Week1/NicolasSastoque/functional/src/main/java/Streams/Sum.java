package Streams;

import java.util.ArrayList;

public class Sum {

    public static void main(String[] args) {
        System.out.println("Streams Sum --->");

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<10; i++){
            list.add(i);
        }

        Integer sum = list.stream().reduce(0, (previous, current) -> previous + current);// Integer::sum
        System.out.println(sum);
    }
}
