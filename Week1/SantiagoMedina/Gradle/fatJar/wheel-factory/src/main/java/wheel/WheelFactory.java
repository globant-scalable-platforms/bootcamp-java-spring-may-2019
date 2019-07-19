package vehiclefactory;

public class WheelFactory {

    public static Wheel build(String vehicle){
        switch(vehicle){
            case "Motorcycle": return new MotorcycleWheel();
            case "Car": return new CarWheel();
        }

        throw new UnsupportedOperationException("Unsupported vehicle: "+ vehicle);
    }
}