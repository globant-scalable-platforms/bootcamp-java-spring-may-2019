package functionalChallenge.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamChallenge {

    public Integer sum(List<Integer> list){
        Stream<Integer> sum = list.stream();
        return sum.reduce(0, (a, b) -> a+b);
    }

    public<E> List<E> getListWithoutDuplicate(List<E> list){
        List<E> listaSinDuplicados = list.stream()
                .distinct()
                .collect(Collectors.toList());
        return listaSinDuplicados;
    }


}
