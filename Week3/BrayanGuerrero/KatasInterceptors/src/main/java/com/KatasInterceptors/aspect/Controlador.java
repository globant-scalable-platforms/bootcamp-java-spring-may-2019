/**
 * 
 */
package com.KatasInterceptors.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brayanguerrero
 *
 */
@RestController
public class Controlador {
	
	private Facade facade;

	@Autowired
	public Controlador(Facade facade) {
	    this.facade = facade;
	}
	
	@GetMapping("/batchTime")
	public String executeBatch(){
	    return facade.execute();
	}

}
