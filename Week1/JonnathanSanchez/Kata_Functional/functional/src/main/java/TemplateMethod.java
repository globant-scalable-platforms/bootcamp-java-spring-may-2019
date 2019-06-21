
import java.util.function.Consumer;

public class TemplateMethod {

    public static void main(String[] args) {
        printMessage("Hello World", p -> System.out.println(p));
    }

    public static String printMessage(String message, Consumer<String> p){
        try {

            String messageToPrint = message.trim().toUpperCase();
            p.accept("preparePapel");
            messageToPrint = decorateMessage(messageToPrint);
            printMessageBrand1(messageToPrint);
            p.accept(" shutting down printer ");

            return messageToPrint;
        } catch (Exception e){
            e.printStackTrace();
        }

        return "failPrinter";
    }


    private static String decorateMessage(String messageToPrint) {
        return  String.format(" %s message decorated with %s",messageToPrint," ********* ") ;
    }

    private static void printMessageBrand1(String messageToPrint) {
        System.out.println(String.format(" %s print --> %s","printerBrand1",messageToPrint));
    }

}

