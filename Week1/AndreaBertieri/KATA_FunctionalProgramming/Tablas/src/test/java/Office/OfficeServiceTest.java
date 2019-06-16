package Office;

import streams.Office.domain.Element;
import streams.Office.domain.Office;
import streams.Office.domain.Table;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.*;

import org.junit.Before;
import org.junit.Test;

public class OfficeServiceTest {

    private Office office;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    

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
    	System.setOut(new PrintStream(outContent));
    	List<Table>oficcesTables=office.getTables();
    	
    	oficcesTables.stream().map(tables->tables.getElements())
    	.flatMap(elements->elements.stream())
    	.map(elemento->elemento.getName().toLowerCase()).sorted().forEach(System.out::println);
    	
    
    			assertEquals("cable\nfolder\nfood\nheadphones\niphone\nkeyboard\nlaptop\nmonitor\nmouse\npaper\npencil\npurse\n", outContent.toString());
    			
    }
}
