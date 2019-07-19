package com.globant.bootcamp.springrest.domain;

public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private Integer age;

    public Student(String firstName, String lastName, String id, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }
}


