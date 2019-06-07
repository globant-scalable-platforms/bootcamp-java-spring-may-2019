package com.globant.bootcamp.spring.springcore.configuration;

import com.globant.bootcamp.spring.springcore.domain.Account;
import com.globant.bootcamp.spring.springcore.domain.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;

@Configuration
public class BeansConfiguration {
    @Bean
    @Scope("singleton")
    public DataSource dataSourceSingleton() {
        return new DataSource(Arrays.asList(new Account("JimenezD","pass1"),
                                            new Account("SuarezQ","pass2"),
                                            new Account("FrancoR","pass3"),
                                            new Account("PerezP","pass4")));
    }
}
