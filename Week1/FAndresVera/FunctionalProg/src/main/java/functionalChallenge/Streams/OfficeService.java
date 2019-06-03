package functionalChallenge.Streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import functionalChallenge.Streams.domain.Element;
import functionalChallenge.Streams.domain.Office;

public class OfficeService {

    public List<Element> retrieveAllElements(Office  office){
        Stream<Element> lista = office.getTables().stream()
                .flatMap(tablas -> tablas.getElements().stream());
        List<Element> sortedList = lista.sorted(Comparator.comparing(Element::getName)).limit(7).collect(Collectors.toList());
        return sortedList;
    }

}
