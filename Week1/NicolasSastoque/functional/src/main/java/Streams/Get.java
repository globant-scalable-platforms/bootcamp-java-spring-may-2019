package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Get {

    public static void main(String[] args) {
        System.out.println("Streams Get --->");

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<10; i++){
            list.add(i);
            list.add(i); //to have repeated elements
        }

        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
