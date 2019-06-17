package vehiclefactory;

public class Body implements BodyMethod {
    private Integer widthBody;
    private Integer heightBody;
    private Integer lengthBody;

    public Body(Integer widthBody, Integer heightBody, Integer lengthBody){
        this.widthBody = widthBody;
        this.heightBody = heightBody;
        this.lengthBody = lengthBody;
    }

    //empty constructor
    public Body(){}

    public Integer getWidthBody(){
        return widthBody;
    }

    public Integer getHeightBody(){
        return heightBody;
    }

    public Integer getLengthBody(){
        return lengthBody;
    }

    public void setWidthBody(Integer widthBody){
        this.widthBody = widthBody;
    }

    public void setHeightBody(Integer heightBody){
        this.heightBody = heightBody;
    }

    public void setLengthBody(Integer lengthBody){
        this.lengthBody = lengthBody;
    }

    @Override
    public void description(){
        System.out.println("The vehicle body has:");
        System.out.println("width of " + getWidthBody());
        System.out.println("height of " + getHeightBody());
        System.out.println("length of " + getLengthBody());
    }

}