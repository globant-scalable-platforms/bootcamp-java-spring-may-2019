package bootcamp.springrest.roleCheck.data;

import bootcamp.springrest.roleCheck.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository(){
        users = new ArrayList<>();

        users.add(new User("Laura", new String[]{"admin", "user"}));
        users.add(new User("Pepito", new String[]{"user"}));
        users.add(new User("Pepita", new String[]{"user"}));
        users.add(new User("Pedro", new String[]{"user"}));
        users.add(new User("María", new String[]{"user"}));
    }

    public List<User> getUsers(){
        return users;
    }
}
