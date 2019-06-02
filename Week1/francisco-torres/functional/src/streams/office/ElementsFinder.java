package streams.office;

import java.util.Arrays;

public class ElementsFinder {

    private Office office;

    public ElementsFinder() {
        setUp();
    }

    public void setUp()  {
        Table table1 = new Table(Arrays.asList(new Element("paper"),new Element("pencil"),new Element("laptop")));
        Table table2 = new Table(Arrays.asList(new Element("cable"),new Element("mouse"),new Element("keyboard")));
        Table table3 = new Table(Arrays.asList(new Element("purse"),new Element("monitor"),new Element("headphones")));
        Table table4 = new Table(Arrays.asList(new Element("iphone"),new Element("folder"),new Element("food")));
        office = new Office(Arrays.asList(table1,table2,table3,table4));
    }

    public void firstSevenElementsOrdered() {
        office.getTables()
              .stream()
              .map(Table -> Table.getElements())
              .flatMap(Element -> Element.stream())
              .sorted((a,b) -> a.getName().compareTo(b.getName()))
              .limit(7)
              .forEach(a -> {System.out.println("  " + a.getName());});
    }

    public static void main(String[] args) {
        ElementsFinder elementsfinder = new ElementsFinder();

        System.out.println("The finder got the first seven elements from the office");
        elementsfinder.firstSevenElementsOrdered();
    }
}
