package bootcamp.springrest.roleCheck.controller;

import bootcamp.springrest.roleCheck.data.UserRepository;
import bootcamp.springrest.roleCheck.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/role-check")
public class RoleCheckController {
    private UserRepository userRepository;

    @Autowired
    public RoleCheckController(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/get-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers(@RequestHeader("roles") String[] roles){

        if(Arrays.stream(roles).anyMatch(s -> s.toLowerCase().equals("admin"))){
            return new ResponseEntity<>(userRepository.getUsers(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }
}
