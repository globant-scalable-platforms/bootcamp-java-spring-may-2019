package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Objects;

public class DataSource {

    private static HashMap<String, String> usersData;

    @PostConstruct
    private static void populateData(){

        usersData = new HashMap<>();

        usersData.put("Mike","secret");
        usersData.put("Juan","RM1280");
        usersData.put("James","Met4ll");
        usersData.put("Robert","L3dZ3p");
        usersData.put("Steve","J0urn3");
        usersData.put("Kurt","N1rv4n");
        usersData.put("Axl","Gnsnrs");

    }

    public User retrieveUserInformation(String username){

        String userpassword = usersData.get(username);

        if(Objects.nonNull(userpassword)){
            return new User(username, userpassword);
        }

        return null;
    }
}
