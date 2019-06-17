package com.globant.bootcamp.functional.functional.katas.streams.Office;

import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Element;
import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Office;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OfficeService {

    public List<Element> retrieveAllElements(Office office){
        Stream<Element> stream = office.getTables().stream().flatMap(t -> t.getElements().stream());

        return stream.sorted(Comparator.comparing(Element::getName)).limit(7).collect(Collectors.toList());
    }
}
