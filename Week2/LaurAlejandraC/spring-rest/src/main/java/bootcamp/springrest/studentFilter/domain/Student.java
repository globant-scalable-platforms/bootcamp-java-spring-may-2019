package bootcamp.springrest.studentFilter.domain;

public class Student {
    private String name;
    private String identification;
    private Integer age;

    public Student(String name, String identification, Integer age){
        this.name = name;
        this.identification = identification;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getIdentification() {
        return identification;
    }

    public Integer getAge() {
        return age;
    }
}
