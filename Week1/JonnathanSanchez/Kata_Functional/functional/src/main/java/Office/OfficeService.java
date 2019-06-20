package Office;

import Office.domain.Element;
import Office.domain.Office;
import Office.domain.Table;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OfficeService {

    public List<Element> retrieveAllElements(Office  office){

        List<Element> retrieveElements = office.getTables().stream().map(table -> table.getElements())
                .flatMap(elements -> elements.stream()).sorted((p1, p2) -> p1.compareTo(p2)).limit(7).collect(Collectors.toList());

        return retrieveElements;
    }
}


