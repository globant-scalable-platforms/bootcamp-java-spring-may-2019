package vehiclefactory;

public class VehicleFactory {

    public static void main (String[] args){

        System.out.println("Welcome to the wheel factory, in this factory only create default wheels");
        System.out.println("This is our catalogue");
        System.out.println("------------------------------------------------");

        // Motorcycle Factory
        Wheel wheelBuild1 = WheelFactory.build("Motorcycle");
        wheelBuild1.setDiameterWheel(3);
        wheelBuild1.setWidthWheel(4);
        wheelBuild1.setWheels(2);
        wheelBuild1.description();    
        System.out.println("------------------------------------------------");   

        //Car Factory
        Wheel wheelBuild2 = WheelFactory.build("Car");
        wheelBuild2.setDiameterWheel(6);
        wheelBuild2.setWidthWheel(8);
        wheelBuild2.setWheels(4);
        wheelBuild2.description(); 
        System.out.println("------------------------------------------------");
    
    }
}