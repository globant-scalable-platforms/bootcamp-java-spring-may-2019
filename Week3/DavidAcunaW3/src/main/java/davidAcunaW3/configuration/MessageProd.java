package davidAcunaW3.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class MessageProd implements Message {

    @Value("${app.message}")
    String message;

    @Override
    public String setup() {
        return message;
    }

}
