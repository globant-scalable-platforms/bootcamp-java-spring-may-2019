package StreamsModel;


import javafx.scene.control.Tab;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class List {

    public static void main(String[] args) {
        System.out.println("Streams List --->");

        Office office = new Office();

        Table southAmericaTable = new Table();
        ArrayList<Element> southAmericaElement = new ArrayList<>(
                Arrays.asList(
                        new Element("Brazil"),
                        new Element("Argentina"),
                        new Element("Peru"),
                        new Element("Colombia"),
                        new Element("Bolivia"),
                        new Element("Venezuela"),
                        new Element("Chile"),
                        new Element("Paraguay"),
                        new Element("Guayana"),
                        new Element("Ecuador"),
                        new Element("Uruguay"),
                        new Element("Suriname")
                )
        );
        southAmericaTable.setElementList(southAmericaElement);

        Table northAmericaTable = new Table();
        ArrayList<Element> northAmericaElement = new ArrayList<>(
                Arrays.asList(
                        new Element("United States"),
                        new Element("Mexico"),
                        new Element("Canada")
                ));
        northAmericaTable.setElementList(northAmericaElement);

        ArrayList<Table> tables = new ArrayList<>();
        tables.add(southAmericaTable);
        tables.add(northAmericaTable);

        office.setTablelist(tables);

        java.util.List<String> collect = office.getTablelist().stream()
                .flatMap(table -> table.getElementList().stream())
                .map(element -> element.getName())
                .sorted()
                .limit(7)
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
