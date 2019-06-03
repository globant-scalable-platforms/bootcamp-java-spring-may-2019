package functionalChallenge;

import java.util.function.Function;

public class Printer {

    public static String printMessage(String message, Function<String, String> d){
        String messageToPrint = message.trim().toUpperCase();
        preparePapel();

        messageToPrint = d.apply(messageToPrint);

        printMessageBrand1(messageToPrint);
        turnOffPrinter();

        return messageToPrint;
    }


    private static void preparePapel() {
        System.out.println("preparePapel");
    }


    private static void printMessageBrand1(String messageToPrint) {
        System.out.println(String.format(" %s print --> %s","printerBrand1",messageToPrint));
    }

    private static void turnOffPrinter() {
        System.out.println(" shutting down printer ");
    }

}
