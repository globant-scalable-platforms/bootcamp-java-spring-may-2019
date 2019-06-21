package Katas.Streams.models;

import java.util.List;

public class Table {
    List<Element> elements;

    public Table() {
    }

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
