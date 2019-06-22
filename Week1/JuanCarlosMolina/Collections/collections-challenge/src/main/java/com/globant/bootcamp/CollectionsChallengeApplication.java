package com.globant.bootcamp;

import com.globant.bootcamp.list.ListImplementationTest;
import com.globant.bootcamp.map.MapImplementationTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectionsChallengeApplication {

	public static void main(String[] args) {

		SpringApplication.run(CollectionsChallengeApplication.class, args);

		ListImplementationTest listTest = new ListImplementationTest();

		MapImplementationTest mapTest = new MapImplementationTest();

		listTest.test();

		mapTest.test();
	}

}
