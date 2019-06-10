package com.globant.bootcamp.spring.Rest.Students.Base;

import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.io.Serializable;


public class Student implements Serializable {

    private String name;
    private int age;
    private int identification;

    public Student(String name, int age, int identification) {
        this.name = name;
        this.age = age;
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }
}
