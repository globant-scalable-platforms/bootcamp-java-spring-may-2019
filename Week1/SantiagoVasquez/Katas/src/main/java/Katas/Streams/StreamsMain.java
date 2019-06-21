package Katas.Streams;

import Katas.Streams.models.Element;
import Katas.Streams.models.Office;
import Katas.Streams.models.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsMain {
    public static void main(String[] args) {
        // Sum all elements in a List using reduce
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        final Integer total = integerList.stream().reduce(0, (subtotal, next) -> subtotal + next);

        System.out.println(total);

        // Get all elements in a List and avoid duplicate values
        List<Integer> repeatedList = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 4, 6, 6, 8, 8, 10));
        repeatedList.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::print);

        // List all elements from all tables and order it alphabetically and show only the first 7 elements
        final Office office = prepareData();
        office.getTables().stream()
                .flatMap(table -> table.getElements().stream())
                .map(element -> element.getElement())
                .sorted()
                .limit(7)
                .forEach(System.out::print);
    }

    private static Office prepareData() {
        Office office = new Office();

        Table tableA = new Table();
        List<Element> elementsA = new ArrayList<>();
        elementsA.add(new Element("G"));
        elementsA.add(new Element("L"));
        elementsA.add(new Element("O"));
        elementsA.add(new Element("B"));
        elementsA.add(new Element("A"));
        elementsA.add(new Element("N"));
        elementsA.add(new Element("T"));

        tableA.setElements(elementsA);

        Table tableB = new Table();
        List<Element> elementsB = new ArrayList<>();
        elementsB.add(new Element("O"));
        elementsB.add(new Element("O"));
        elementsB.add(new Element("T"));
        elementsB.add(new Element("C"));
        elementsB.add(new Element("A"));
        elementsB.add(new Element("M"));
        elementsB.add(new Element("P"));

        tableB.setElements(elementsB);

        List<Table> tables = new ArrayList<>();

        tables.add(tableA);
        tables.add(tableB);

        office.setTables(tables);

        return office;
    }
}
