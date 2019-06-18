package TemplateMethod;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

class Calculate{


    private Calculate(){
        System.out.println("Creating...");
    }

    public static void use(Consumer<Calculate> useCalculate){
        Calculate calculate = new Calculate();
    }
    public  Integer execute(int a, int b) {
        return a+b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Calculate.use(calculate -> calculate.execute(2,3));
    }
}
