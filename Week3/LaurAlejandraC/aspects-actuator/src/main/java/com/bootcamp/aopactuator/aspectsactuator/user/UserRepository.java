package com.bootcamp.aopactuator.aspectsactuator.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {
    private Map<Integer, User> users;

    public UserRepository(){
        users = new HashMap<>();

        users.put(1, new User(1, "Pepito", "Pérez"));
        users.put(2, new User(2, "Pepita", "Suárez"));
        users.put(3, new User(3, "Camilo", "Heredia"));
        users.put(4, new User(4, "Francisco", "Ramírez"));
    }

    public List<User> getUsersList(){
        return new ArrayList<>(users.values());
    }

    public boolean deleteUser(int id){
        return users.remove(id) != null;
    }
}
