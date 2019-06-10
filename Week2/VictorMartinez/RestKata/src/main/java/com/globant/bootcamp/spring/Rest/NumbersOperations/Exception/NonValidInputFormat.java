package com.globant.bootcamp.spring.Rest.NumbersOperations.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NonValidInputFormat extends NumberFormatException {


    public NonValidInputFormat(String message){
        super(message);
    }

}
