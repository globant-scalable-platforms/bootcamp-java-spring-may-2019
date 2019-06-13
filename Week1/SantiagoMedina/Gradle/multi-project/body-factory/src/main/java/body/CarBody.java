package vehiclefactory;

public class CarBody extends Body{

    public CarBody(Integer widthBody, Integer heightBody, Integer lengthBody){
        super(widthBody, heightBody, lengthBody);
    }

    //empty constructor
    public CarBody(){}

    @Override
    public void description(){
        System.out.println("The car body has:");
        System.out.println("width of " + getWidthBody());
        System.out.println("height of " + getHeightBody());
        System.out.println("length of " + getLengthBody());
    }
}