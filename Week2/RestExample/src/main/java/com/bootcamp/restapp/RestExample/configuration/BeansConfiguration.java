package com.bootcamp.restapp.RestExample.configuration;

import com.bootcamp.restapp.RestExample.data.DataSource;
import com.bootcamp.restapp.RestExample.data.StudentRepository;
import com.bootcamp.restapp.RestExample.data.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public DataSource getDataSource(){
        return new DataSource();
    }

    @Bean
    public StudentRepository getStudentRepository(){
        return new StudentRepositoryImpl();
    }

}
