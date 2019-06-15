package com.bootcamp.aopactuator.aspectsactuator.aspect.otherPackage;

import org.springframework.stereotype.Component;

@Component
public class MessiCelebration implements Celebration {

    public String celebrate() {
        return "Goaaaaaal!";
    }
}
