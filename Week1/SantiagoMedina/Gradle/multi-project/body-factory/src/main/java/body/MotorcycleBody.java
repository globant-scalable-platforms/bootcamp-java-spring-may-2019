package vehiclefactory;

public class MotorcycleBody extends Body {

    public MotorcycleBody(Integer widthBody, Integer heightBody, Integer lengthBody){
        super(widthBody, heightBody, lengthBody);
    }

    //empty constructor
    public MotorcycleBody(){}

    @Override
    public void description(){
        System.out.println("The motorcycle body has:");
        System.out.println("width of " + getWidthBody());
        System.out.println("height of " + getHeightBody());
        System.out.println("length of " + getLengthBody());
    }
}