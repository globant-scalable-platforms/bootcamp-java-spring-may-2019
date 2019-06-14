package com.globant.bootcamp.spring.springcore.data;

import com.globant.bootcamp.spring.springcore.domain.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Qualifier("DataSource")
public class DataSource {

    HashMap<String, String> usersInfo;

    public DataSource(){
        usersInfo = new HashMap<>();

        usersInfo.put("Andres", "1234");
        usersInfo.put("Antonio", "absd");
        usersInfo.put("Mike", "secret");
        usersInfo.put("Tony", "Stark");
        usersInfo.put("Juan", "060754");
        usersInfo.put("Andrea", "I<3NY");
        usersInfo.put("Natalia", "SailorMoon");
        usersInfo.put("Luis", "Functional");
     }


     public HashMap<String, String> getUsersInfo(){
        return this.usersInfo;
     }

     public Account retrieveUserInformation(String username){
        if(usersInfo.containsKey(username)){
            return new Account(username, usersInfo.get(username));
        }
        else {
            return null;
        }

     }

     public String getPassWord(String username){
        return usersInfo.get(username);
     }

     public List<String> getAllUsers(){
        ArrayList<String> names = new ArrayList<String>(usersInfo.keySet());
        return names;
     }


}
