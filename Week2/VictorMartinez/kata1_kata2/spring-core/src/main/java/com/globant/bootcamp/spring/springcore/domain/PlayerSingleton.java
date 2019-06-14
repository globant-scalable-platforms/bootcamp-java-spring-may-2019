package com.globant.bootcamp.spring.springcore.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("singleton")
@Qualifier("PlayerSingleton")
public class PlayerSingleton extends Player {

    public PlayerSingleton(){

        super("Player Singleton");
    }


}
