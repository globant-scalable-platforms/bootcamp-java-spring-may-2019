package StreamsModel;

import java.util.List;

public class Office {

    private List<Table> tablelist;

    public Office(){}

    public Office(List<Table> tablelist) {
        this.tablelist = tablelist;
    }

    public List<Table> getTablelist() {
        return tablelist;
    }

    public void setTablelist(List<Table> tablelist) {
        this.tablelist = tablelist;
    }
}
