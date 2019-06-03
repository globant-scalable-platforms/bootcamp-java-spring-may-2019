import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Streams {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<>();

        for (int i = 0; i <= 100; i++){
            data.add(i);
        }

        Integer resultReduce = data.stream().reduce(0, Integer::sum);

        System.out.println("Sum all elements in a list: " + resultReduce);

        List<Integer> dataDuplicateElements = new ArrayList<>();
        dataDuplicateElements.add(1);
        dataDuplicateElements.add(2);
        dataDuplicateElements.add(2);
        dataDuplicateElements.add(3);
        dataDuplicateElements.add(4);

        System.out.println("Avoid duplicate elements");
        System.out.println(dataDuplicateElements);

        List<Integer> dataAvoidElements = dataDuplicateElements.stream().distinct().collect(Collectors.toList());

        System.out.println(dataAvoidElements);
    }

}
