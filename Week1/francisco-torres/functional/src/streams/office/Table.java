package streams.office;

import java.util.List;

public class Table {

    private List<Element> elements;

    public Table(List<Element> elements) {
        this.elements = elements;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}