package com.globant.bootcamp.functional.functional.katas.lambdas.templatemethod;

import java.util.function.Function;

public class Printer {


    public static String printMessage(String message, Function<String, String> decorator){
        String messageToPrint = message.trim().toUpperCase();

        try{
            preparePaper();
            messageToPrint = decorator.apply(messageToPrint);
            printMessageBrand1(messageToPrint) ;
        }
        catch (Exception ex){
            System.err.println("Fail to apply decorator due to: " + ex.getMessage());
        }
        finally {
            turnOffPrinter();
        }

        return messageToPrint;
    }


    private static void preparePaper() {
        System.out.println("preparePaper");
    }

    private static void printMessageBrand1(String messageToPrint) {
        System.out.println(String.format(" %s print --> %s","printerBrand1",messageToPrint));
    }

    private static void turnOffPrinter() {
        System.out.println(" shutting down printer ");
    }
}
