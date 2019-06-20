package davidAcuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import davidAcuna.business.Authenticator;

@RestController
public class AuthenticatorController {
    
    @Autowired
    Authenticator authenticator;
    
    @GetMapping(value="/authenticate/{username}/{password}")
    public boolean authenticate(@PathVariable String username, @PathVariable String password) {
        return authenticator.authenticate(username, password);
    }
    

}
