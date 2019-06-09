package com.bootcamp.restchallenge.configuration;

import com.bootcamp.restchallenge.data.*;
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

    @Bean
    @Scope("singleton")
    public NumericControllerInterface numericController() {
        return new NumericControllerImpl();
    }

    @Bean
    @Scope("singleton")
    public NumericCSVFileToListInterface numericCSVFileToList() {
        return new NumericCSVFileToListImpl();
    }

    @Bean
    @Scope("singleton")
    public StudentsControllerInterface studentsController() {
        return new StudentsControllerImpl();
    }
}
