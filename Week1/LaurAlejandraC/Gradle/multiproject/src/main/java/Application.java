public class Application {
    public static void main(String[] args){
        Operations operations = new Operations();

        System.out.println("Sum 4 and 5: " + operations.sum(4, 5));
        System.out.println("Subtract 6 from 10: " + operations.subtract(10, 6));
        System.out.println("Multiply 5 by 34: " + operations.multiply(5, 34));
    }
}
