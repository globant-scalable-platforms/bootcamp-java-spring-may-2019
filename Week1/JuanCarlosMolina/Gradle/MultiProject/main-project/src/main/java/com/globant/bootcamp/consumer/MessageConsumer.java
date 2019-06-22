package com.globant.bootcamp.consumer;

import com.globant.bootcamp.service.MessageServiceProvider;

public class MessageConsumer {

    private MessageServiceProvider messageServiceProvider;

    public String consumeService(){

        messageServiceProvider = new MessageServiceProvider();

        return messageServiceProvider.getMessage();
    }


}
