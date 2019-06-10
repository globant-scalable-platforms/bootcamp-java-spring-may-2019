package com.globant.bootcamp.spring.Rest.Roles.Exception;

import java.util.Date;

public class ExceptionResponses {


    private Date fromDate;
    private String message;
    private String details;

    public ExceptionResponses(Date fromDate, String message, String details){
        super();
        this.fromDate = fromDate;
        this.message  = message;
    }

}
