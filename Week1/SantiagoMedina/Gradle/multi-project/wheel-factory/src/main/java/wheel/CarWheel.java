package vehiclefactory;

public class CarWheel extends Wheel{

    public CarWheel(Integer diameterWheel, Integer widthWheel, Integer wheels){
        super(diameterWheel, widthWheel, wheels);
    }

    //empty constructor
    public CarWheel(){}

    @Override
    public void description(){
        System.out.println("The car has:");
        System.out.println(getWheels() + " wheels");
        System.out.println("the diameter of each wheel is " + getDiameterWheel());
        System.out.println("the width of each wheel is " + getWidthWheel());
    }
}