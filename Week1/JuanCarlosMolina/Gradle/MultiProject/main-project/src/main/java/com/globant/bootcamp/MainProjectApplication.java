package com.globant.bootcamp;

import com.globant.bootcamp.consumer.MessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MainProjectApplication {

	private static Logger log = LoggerFactory.getLogger(MainProjectApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MainProjectApplication.class, args);

		log.info("Getting message from sub-project service");

		log.warn(new MessageConsumer().consumeService());

		log.info("Service consumed");
	}


}
