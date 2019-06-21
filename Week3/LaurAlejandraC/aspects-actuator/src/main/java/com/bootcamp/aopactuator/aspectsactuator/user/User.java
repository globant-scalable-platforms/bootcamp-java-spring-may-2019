package com.bootcamp.aopactuator.aspectsactuator.user;

public class User {
    private Integer id;
    private String name;
    private String surname;

    public User(Integer id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString(){
        return this.id + ": " + this.name + " " + this.surname;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
