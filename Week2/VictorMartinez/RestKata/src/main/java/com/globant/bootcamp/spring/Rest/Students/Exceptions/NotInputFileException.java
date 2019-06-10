package com.globant.bootcamp.spring.Rest.Students.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotInputFileException extends IllegalArgumentException {
    public NotInputFileException(String message){super(message);}
}




