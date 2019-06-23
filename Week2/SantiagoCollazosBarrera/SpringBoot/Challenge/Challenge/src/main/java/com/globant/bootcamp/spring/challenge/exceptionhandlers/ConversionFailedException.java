/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.spring.challenge.exceptionhandlers;

import java.util.Date;

/**
 *
 * @author Santiago Collazos Barrera
 */
public class ConversionFailedException extends Exception{
    
    private Date date;
    private String message;
    
    public ConversionFailedException(Date date, String message) {
        this.date = date;
        this.message = message;
      
    }
    
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
