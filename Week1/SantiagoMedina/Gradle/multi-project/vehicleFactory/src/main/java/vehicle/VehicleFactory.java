package vehiclefactory;

import java.io.InputStream;
import java.util.*; 

public class VehicleFactory {

    public static void main (String[] args){

        Welcome();
        int option;
        InputStream stream = System.in;
		Scanner scanner = new Scanner(System.in);
		option = scanner.nextInt();

        switch(option){
            case 1:
                // Motorcycle Factory
                Wheel wheelMotorcycle = WheelFactory.build("Motorcycle");
                wheelMotorcycle.setDiameterWheel(3);
                wheelMotorcycle.setWidthWheel(4);
                wheelMotorcycle.setWheels(2);

                Body bodyMotorcycle = BodyFactory.build("Motorcycle");
                bodyMotorcycle.setWidthBody(20);
                bodyMotorcycle.setHeightBody(30);
                bodyMotorcycle.setLengthBody(40);

                wheelMotorcycle.description(); 
                bodyMotorcycle.description();  
                System.out.println("------------------------------------------------");    
            break;
            case 2:
                //Car Factory
                Wheel wheelCar = WheelFactory.build("Car");
                wheelCar.setDiameterWheel(6);
                wheelCar.setWidthWheel(8);
                wheelCar.setWheels(4);

                Body bodyCar = BodyFactory.build("Car");
                bodyCar.setWidthBody(40);
                bodyCar.setHeightBody(60);
                bodyCar.setLengthBody(80);

                wheelCar.description(); 
                bodyCar.description(); 
                System.out.println("------------------------------------------------");
            break;
            default:
                System.out.println("It is not a valid option");
                System.out.println("Bye");
            break;
        }
    
    }

    public static void Welcome(){
        System.out.println("Welcome to the wheel factory, in this factory only create default wheels and chassis");
        System.out.println("This is our catalogue");
        System.out.println("------------------------------------------------");
        System.out.println("1. Motorcycle");
        System.out.println("2. Car");
        System.out.println("------------------------------------------------");
        System.out.println("Please select the number you need");
    }
}