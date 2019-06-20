package Office.domain;

public class Element {

    private String name;

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo (Element a){
        return this.getName().compareTo(a.getName());
    }

}
