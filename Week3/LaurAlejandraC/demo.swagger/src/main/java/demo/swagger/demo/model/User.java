package demo.swagger.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("id") private Integer id;
    @JsonProperty("name") private String name;
    @JsonProperty("surname") private String surname;

    @JsonCreator
    public User(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("surname") String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
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
