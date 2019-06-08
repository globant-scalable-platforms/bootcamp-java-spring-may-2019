package functionalChallenge;

import functionalChallenge.Printer;
import org.junit.Assert;
import org.junit.Test;

public class PrinterTest {
    @Test
    public void print(){
        Assert.assertEquals(Printer.printMessage("Message", (String toFormat) ->
                String.format("%s message decorated with %s", toFormat, " ********* ")),
                "MESSAGE message decorated with  ********* ");
    }
}
