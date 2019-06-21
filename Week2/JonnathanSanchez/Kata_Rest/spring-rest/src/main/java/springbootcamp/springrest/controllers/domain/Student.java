package springbootcamp.springrest.controllers.domain;

public class Student {

    private String name;
    private String identification;
    private Integer age;

    public Student(String name, String identification, int age) {
        this.name = name;
        this.identification = identification;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
