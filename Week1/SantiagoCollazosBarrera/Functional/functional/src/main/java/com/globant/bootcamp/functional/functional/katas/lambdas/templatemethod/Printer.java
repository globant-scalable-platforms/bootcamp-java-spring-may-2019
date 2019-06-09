package com.globant.bootcamp.functional.functional.katas.lambdas.templatemethod;

import java.util.function.Consumer;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Printer {
    
    static Logger logger = Logger.getAnonymousLogger();

    private Printer() {
    }

    public static String printMessage(Consumer<String> section, String message) {
        String messageToPrint = message.trim().toUpperCase();
        
        section.accept("preparePapel");
        try {
            messageToPrint = decorateMessage(messageToPrint);
            printMessageBrand1(messageToPrint);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "an exception was thrown", e);
        }
        section.accept(" shutting down printer ");
        return messageToPrint;
    }

    private static void preparePapel() {
        System.out.println("preparePapel");
    }

    private static String decorateMessage(String messageToPrint) {
        return String.format(" %s message decorated with %s", messageToPrint, " ********* ");
    }

    private static void printMessageBrand1(String messageToPrint) {
        System.out.println(String.format(" %s print --> %s", "printerBrand1", messageToPrint));
    }

    private static void turnOffPrinter() {
        System.out.println(" shutting down printer ");
    }

    public static void main(String[] args) {
        Printer.printMessage(p -> System.out.println(p),"Bootcamp Globant !!!");
    }
}