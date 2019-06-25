/**
 * 
 */
package com.KatasInterceptors.aspect;

import org.springframework.stereotype.Component;

/**
 * @author brayanguerrero
 *
 */
@Component
public class Facade implements Command{

    public String execute() {
        return "Perfect!!";
    }
}