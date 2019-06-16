package lambdas.pattern;

import lambdas.pattern.Printer;

public class User {
    public static void main(String[] args) {
        Printer.process(printer -> {
            printer.printMessageBrand(printer.decorateMessage("|This is the message.|"));
        });
    }
}
