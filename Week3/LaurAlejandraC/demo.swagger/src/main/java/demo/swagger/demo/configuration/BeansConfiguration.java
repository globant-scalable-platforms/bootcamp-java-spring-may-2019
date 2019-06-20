package demo.swagger.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.RequestHandlerSelectors;

@Configuration
public class BeansConfiguration {
    @Bean
    public Docket documentationApi(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("demo.swagger.demo")).build();
    }
}
