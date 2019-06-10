package com.globant.bootcamp.spring.RestKata.Exceptions;

import java.util.Date;

public class errorDetails {

    private Date fromDate;
    private String message;
    private String details;

    public errorDetails(Date fromDate, String message, String details){
        super();
        this.fromDate = fromDate;
        this.message  = message;
        this.details  = details;
    }

}
