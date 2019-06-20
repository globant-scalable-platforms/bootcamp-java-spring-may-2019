package StreamsModel;


import java.util.List;

public class Table {

    private List<Element> elementList;

    public Table(){}

    public Table(List<Element> elementList) {
        this.elementList = elementList;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }

}
