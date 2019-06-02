package lambdas.pattern;

import java.util.function.Consumer;

public class Printer {

    private Printer() {
        preparePapel();
    }

    private static void preparePapel() {
        System.out.println("Prepare papel");
    }

    public static String decorateMessage(String messageToPrint) {
        return  String.format("%s message decorated with %s",messageToPrint,"*********");
    }

    public static void printMessageBrand(String messageToPrint) {
        System.out.println(String.format("%s print --> %s","printerBrand",messageToPrint));
    }

    private static void turnOffPrinter() {
        System.out.println("Shutting down printer");
    }

    public static void process(Consumer<Printer> tasks) {
        Printer printer = new Printer();
        try {
            tasks.accept(printer);
        }finally {
            printer.turnOffPrinter();
        }
    }
}
