package com.globant.bootcamp.springrest.configuration;

import com.globant.bootcamp.springrest.domain.Student;
import com.globant.bootcamp.springrest.domain.StudentDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

@Configuration
public class BeansConfiguration {

    @Bean
    @Scope("singleton")
    public StudentDataSource dataSourceSingleton() {
        return new StudentDataSource(Arrays.asList(new Student("Juan","Perez","1245878",22),
                                                    new Student("Pedro","Suarez","256584",21),
                                                    new Student("Ana","Rodriguez","100014",26),
                                                    new Student("Paola","Juarez","455852",33),
                                                    new Student("Paula","Ramirez","454522",19),
                                                    new Student("Pedro","Rodriguez","224522",21)));
    }
}
