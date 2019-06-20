package demo.swagger.demo.data;

import demo.swagger.demo.model.User;
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
        users.put(1, new User(1, "Perencejo", "Perez"));
        users.put(2, new User(2, "Perenceja", "Ramirez"));
        users.put(3, new User(3, "Pepito", "Suarez"));
    }

    public boolean addUser(User user){
        if(!users.containsKey(user.getId())){
            users.put(user.getId(), user);
            return true;
        }

        return false;
    }

    public boolean deleteUser(Integer id){
        if(users.containsKey(id)){
            users.remove(id);
            return true;
        }

        return false;
    }

    public boolean updateUser(User user){
        if(users.containsKey(user.getId())){
            users.put(user.getId(), user);
            return true;
        }

        return false;
    }

    public List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }

    public User getUserById(Integer id){
        return users.get(id);
    }
}
