package com.bootcamp.restchallenge.domain;

public class Student {

    private String name;
    private String identification;
    private int age;

    public Student() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
