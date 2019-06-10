package com.globant.bootcamp.spring.Rest.Roles.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongHeaderNameException extends IllegalArgumentException {
    public WrongHeaderNameException(String message){super(message);}
}
