package vehiclefactory;

public class MotorcycleWheel extends Wheel {

    public MotorcycleWheel(Integer diameterWheel, Integer widthWheel, Integer wheels){
        super(diameterWheel, widthWheel, wheels);
    }

    //empty constructor
    public MotorcycleWheel(){}

    @Override
    public void description(){
        System.out.println("The motorcycle wheel have:");
        System.out.println(getWheels() + " wheels");
        System.out.println("the diameter of each wheel is " + getDiameterWheel());
        System.out.println("the width of each wheel is " + getWidthWheel());
    }
}