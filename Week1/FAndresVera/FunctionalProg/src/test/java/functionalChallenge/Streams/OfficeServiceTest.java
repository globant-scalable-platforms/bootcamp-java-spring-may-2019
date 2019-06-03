package functionalChallenge.Streams;

import functionalChallenge.Streams.domain.Element;
import functionalChallenge.Streams.domain.Office;
import functionalChallenge.Streams.domain.Table;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class OfficeServiceTest {

    private Office office;

    @Before
    public void setUp() throws Exception {
        Table table1 = new Table(Arrays.asList(new Element("Paper"),new Element("pencil"),new Element("laptop")));
        Table table2 = new Table(Arrays.asList(new Element("Cable"),new Element("Mouse"),new Element("keyboard")));
        Table table3 = new Table(Arrays.asList(new Element("purse"),new Element("monitor"),new Element("headphones")));
        Table table4 = new Table(Arrays.asList(new Element("iphone"),new Element("folder"),new Element("food")));
        office = new Office(Arrays.asList(table1,table2,table3,table4));
    }


    @Test
    public void first7ElementsOrdered() {
        // code goes here !

    }
}
