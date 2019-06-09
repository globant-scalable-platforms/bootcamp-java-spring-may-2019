package com.bootcamp.restchallenge.configuration;

import com.bootcamp.restchallenge.data.DateValidationImpl;
import com.bootcamp.restchallenge.data.DateValidationInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeansConfiguration {

    @Bean
    @Scope("singleton")
    public DateValidationInterface dateOperation() {
        return new DateValidationImpl();
    }
}
