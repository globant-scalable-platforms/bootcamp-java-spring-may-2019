package com.globant.bootcamp.spring.Rest.Roles.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotAdminPropertyFoundException extends IllegalArgumentException {

    public NotAdminPropertyFoundException(String message){
        super(message);
    }
}
