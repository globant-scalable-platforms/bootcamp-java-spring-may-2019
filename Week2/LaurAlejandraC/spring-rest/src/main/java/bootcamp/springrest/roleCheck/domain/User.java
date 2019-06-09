package bootcamp.springrest.roleCheck.domain;

import java.util.Arrays;

public class User {
    private String name;
    private String[] roles;

    public User(String name, String[] roles){
        this.name = name;
        this.roles = roles;
    }

    @Override
    public String toString(){
        return this.name + ", " + Arrays.toString(roles);
    }

    public String getName() {
        return name;
    }

    public String[] getRoles() {
        return roles;
    }
}
