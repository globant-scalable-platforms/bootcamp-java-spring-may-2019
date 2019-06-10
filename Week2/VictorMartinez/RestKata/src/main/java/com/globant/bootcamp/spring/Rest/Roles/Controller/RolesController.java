package com.globant.bootcamp.spring.Rest.Roles.Controller;

import com.globant.bootcamp.spring.Rest.Roles.Exception.NotAdminPropertyFoundException;
import com.globant.bootcamp.spring.Rest.Roles.Exception.WrongHeaderNameException;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class RolesController {


    @RequestMapping(value = "/roles", method = GET)
    public ResponseEntity<String> greeting(@RequestBody String body, @RequestHeader HttpHeaders headers){
            Map<String, String>  headersMap= headers.toSingleValueMap();

            System.out.println(headers.getValuesAsList("name").get(0).equals("roles"));
            System.out.println(headersMap.get("name"));
            if(!headersMap.get("name").equalsIgnoreCase("roles")){
                    throw new WrongHeaderNameException("Wrong Filename - roles is not set");
                }

            if(!headersMap.containsValue("admin")){
                    throw new NotAdminPropertyFoundException("Admin doesnt exist as a role in header");
            }

       return new ResponseEntity<String>(HttpStatus.OK);
    }


}



