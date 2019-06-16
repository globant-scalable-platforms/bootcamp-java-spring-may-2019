package dependingproject;

public class JavaProject{
    public static void main(String[] args) {
        final String output = Library.greeting(args[0]);
        System.out.println(output);
    }
}
