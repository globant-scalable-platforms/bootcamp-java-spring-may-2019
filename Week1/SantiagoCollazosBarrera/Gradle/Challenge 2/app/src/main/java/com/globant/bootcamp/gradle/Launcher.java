/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.gradle;

import com.globant.bootcamp.gradle.service.ServiceMessage;

/**
 *
 * @author SantiagoCollazosBarrera
 */
public class Launcher {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServiceMessage service = new ServiceMessage();
        
        String message = service.getMessage();
        System.out.println("Received message: " + message);        
    }
    
}
