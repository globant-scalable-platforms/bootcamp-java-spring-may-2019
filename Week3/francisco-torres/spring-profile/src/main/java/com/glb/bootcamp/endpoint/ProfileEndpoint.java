package com.glb.bootcamp.endpoint;


import com.glb.bootcamp.config.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileEndpoint {

    @Autowired
    private Message message;

    @RequestMapping(value = "/info")
    public String getMessage(){
        return message.setup();
    }
}
