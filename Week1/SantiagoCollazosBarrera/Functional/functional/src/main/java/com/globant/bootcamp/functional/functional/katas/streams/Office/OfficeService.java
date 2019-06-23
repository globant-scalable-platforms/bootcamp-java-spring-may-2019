package com.globant.bootcamp.functional.functional.katas.streams.Office;

import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Element;
import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Office;
import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Table;
import java.util.ArrayList;

import java.util.Comparator;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class OfficeService {

    public List<Element> retrieveAllElements(Office office){        
        return office.getTables().stream().map(table -> table.getElements())
                .flatMap(elements -> elements.stream()).sorted(Comparator.comparing(Element::getName)).limit(7).collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        ArrayList<Element> elements = new ArrayList();
        elements.add(new Element("Letter"));
        elements.add(new Element("Computer"));
        elements.add(new Element("Mouse"));
        
        ArrayList<Element> elements1 = new ArrayList();
        elements1.add(new Element("Eraser"));
        elements1.add(new Element("Pen"));
        elements1.add(new Element("Rule"));
        
        ArrayList tables = new ArrayList();
        tables.add(new Table(elements));
        tables.add(new Table(elements1));    
        
        OfficeService o = new OfficeService();  
        Office of = new Office(tables);
        List l = o.retrieveAllElements(of);
        
        
        for (Object object : l) {
            System.out.println(String.valueOf(((Element)object).getName()));
        }
    }
}
