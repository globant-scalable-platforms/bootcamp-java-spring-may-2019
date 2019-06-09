package com.bootcamp.restchallenge.configuration;

import com.bootcamp.restchallenge.controller.interceptor.RolesHeaderValidatorInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ControllerConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RolesHeaderValidatorInterceptor()).addPathPatterns("/challenge/header/validation");
    }
}
