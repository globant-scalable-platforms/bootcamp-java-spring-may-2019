package com.globant.bootcamp.functional.functional.katas.lambdas.templatemethod;

import java.util.function.Consumer;

public class Printer {

    private Printer() {
    }

    public static String printMessage(Consumer<String> section, String message) {
        String messageToPrint = message.trim().toUpperCase();
        //preparePapel();
        section.accept("preparePapel");
        try {
            messageToPrint = decorateMessage(messageToPrint);
            printMessageBrand1(messageToPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        section.accept(" shutting down printer ");
        //turnOffPrinter();

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