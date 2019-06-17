package com.globant.bootcamp.functional.functional.katas.lambdas;

import com.globant.bootcamp.functional.functional.katas.lambdas.templatemethod.Printer;
import org.junit.Assert;
import org.junit.Test;

public class PrinterTest {
    @Test
    public void print(){
        Assert.assertEquals(Printer.printMessage("This is a message", (String toFormat) -> String.format(" %s message decorated with %s", toFormat, " ********* ")), " THIS IS A MESSAGE message decorated with  ********* ");
    }
}
