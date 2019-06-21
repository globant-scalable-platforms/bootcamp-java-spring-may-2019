package com.glb.bootcamp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageDefault implements Message{

    @Value("${app.message}")
    String message;

    @Override
    public String setup() {
        return message;
    }
}
