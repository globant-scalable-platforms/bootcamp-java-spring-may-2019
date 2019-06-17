package com.globant.bootcamp.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping
    public ResponseEntity validateRoles(@RequestHeader("roles") String roles) {
        for (String role: roles.split(",")) {
            if(role.equals("admin")) {
                return ResponseEntity.status(HttpStatus.OK).body("you have the admin permissions.");
            }
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("you do not have the admin permissions.");
    }
}
