package streams.Office.domain;

import java.util.List;


public class Office {

    private List<Table> tables;

    public Office(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
}
