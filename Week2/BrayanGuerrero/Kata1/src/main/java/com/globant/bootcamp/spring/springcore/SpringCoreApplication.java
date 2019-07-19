package com.globant.bootcamp.spring.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.globant.bootcamp.spring.springcore.business")
@ComponentScan("com.globant.bootcamp.spring.springcore.data")
@ComponentScan("com.globant.bootcamp.spring.springcore.controller")
public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
	}

}
