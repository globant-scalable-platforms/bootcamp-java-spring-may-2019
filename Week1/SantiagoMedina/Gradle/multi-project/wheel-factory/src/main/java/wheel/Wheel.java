package vehiclefactory;

public class Wheel implements InterfaceWheel {
    private Integer diameterWheel;
    private Integer widthWheel;
    private Integer wheels;

    public Wheel(Integer diameterWheel, Integer widthWheel, Integer wheels){
        this.diameterWheel = diameterWheel;
        this.widthWheel = widthWheel;
        this.wheels = wheels;
    }

    //empty constructor
    public Wheel(){}

    public Integer getDiameterWheel(){
        return diameterWheel;
    }

    public Integer getWidthWheel(){
        return widthWheel;
    }

    public Integer getWheels(){
        return wheels;
    }

    public void setDiameterWheel(Integer diameterWheel){
        this.diameterWheel = diameterWheel;
    }

    public void setWidthWheel(Integer widthWheel){
        this.widthWheel = widthWheel;
    }

    public void setWheels(Integer wheels){
        this.wheels = wheels;
    }

    @Override
    public void description(){
        System.out.println("The vehicle wheel have:");
        System.out.println(getWheels() + " wheels");
        System.out.println("the diameter of each wheel is " + getDiameterWheel());
        System.out.println("the width of each wheel is " + getWidthWheel());
    }

}