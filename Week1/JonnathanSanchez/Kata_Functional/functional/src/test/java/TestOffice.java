import Office.domain.Element;
import Office.domain.Office;
import Office.domain.Table;
import Office.OfficeService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestOffice {

    @Test
    public void retrieveElements() {
        List<Element> elements = new ArrayList<>();
        elements.add(new Element("vaso"));
        elements.add(new Element("carro"));
        elements.add(new Element("tv"));
        elements.add(new Element("telefono"));
        elements.add(new Element("armario"));
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(elements));
        tables.add(new Table(elements));
        tables.add(new Table(elements));
        tables.add(new Table(elements));
        tables.add(new Table(elements));


        Office office = new Office(tables);

        OfficeService officeService = new OfficeService();
        officeService.retrieveAllElements(office).forEach(element -> System.out.println(element.getName()));

    }
}
