package com.globant.bootcamp.spring.springcore.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
@Qualifier("PlayerPrototype")
public class PlayerPrototype extends Player {

    public PlayerPrototype(){
        super("Player Prototype");
    }

}
