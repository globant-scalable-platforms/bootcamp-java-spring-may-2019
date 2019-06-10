package com.globant.bootcamp.spring.Rest.NumbersOperations;

import com.globant.bootcamp.spring.Rest.NumbersOperations.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})

public class NumbersRestKataApplication {
    public static void main(String [] args){
        SpringApplication.run(NumbersRestKataApplication.class);
    }
}
