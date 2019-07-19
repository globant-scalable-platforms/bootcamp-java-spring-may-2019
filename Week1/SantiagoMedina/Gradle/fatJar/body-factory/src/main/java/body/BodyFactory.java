package vehiclefactory;

public class BodyFactory {

    public static Body build(String vehicle){
        switch(vehicle){
            case "Motorcycle": return new MotorcycleBody();
            case "Car": return new CarBody();
        }

        throw new UnsupportedOperationException("Unsupported vehicle: "+ vehicle);
    }
}