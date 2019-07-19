package com.globant.bootcamp.functional.functional.katas.lambdas.templatemethod;

public class Printer {


    public static String printMessage(String message){
        String messageToPrint = message.trim().toUpperCase();
        preparePapel();
        messageToPrint = decorateMessage(messageToPrint);
        printMessageBrand1(messageToPrint);
        turnOffPrinter();

        return messageToPrint;
    }


    private static void preparePapel() {
        System.out.println("preparePapel");
    }

    private static String decorateMessage(String messageToPrint) {
        return  String.format(" %s message decorated with %s",messageToPrint," ********* ") ;
    }

    private static void printMessageBrand1(String messageToPrint) {
        System.out.println(String.format(" %s print --> %s","printerBrand1",messageToPrint));
    }

    private static void turnOffPrinter() {
        System.out.println(" shutting down printer ");
    }
}
