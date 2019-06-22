package com.bootcamp.aopactuator.aspectsactuator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AspectsActuatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AspectsActuatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
