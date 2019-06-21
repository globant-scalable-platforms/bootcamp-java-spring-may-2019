package com.bootcamp.kata.controller;

import com.bootcamp.kata.controller.model.ParticipateRequest;
import com.bootcamp.kata.controller.model.ParticipateResponse;
import com.bootcamp.kata.data.HighScoreGameInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/high-score/{player}")
public class HighRandomScoreController {

    @Autowired
    @Qualifier(value = "singletonGame")
    private HighScoreGameInterface singletonGame;

    @Autowired
    @Qualifier(value = "prototypeGame")
    private HighScoreGameInterface prototypeGame;

    @PostMapping(path = "/singleton")
    public ParticipateResponse singletonHighScoreGame(@PathVariable("player") @NotNull(message = "Debe ingresar un nombre de jugador") String player, @RequestBody @Valid ParticipateRequest body) {
        final String winnerName = singletonGame.participate(player, body.getScore());
        return new ParticipateResponse(winnerName);
    }

    @PostMapping(path = "/prototype")
    public ParticipateResponse PrototypeHighScoreGame(@PathVariable("player") @NotNull(message = "Debe ingresar un nombre de jugador") String player, @RequestBody @Valid ParticipateRequest body) {
        final String winnerName = prototypeGame.participate(player, body.getScore());
        return new ParticipateResponse(winnerName);
    }
}
