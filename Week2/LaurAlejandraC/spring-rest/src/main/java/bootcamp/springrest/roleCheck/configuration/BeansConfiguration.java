package bootcamp.springrest.roleCheck.configuration;

import bootcamp.springrest.roleCheck.data.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

}
