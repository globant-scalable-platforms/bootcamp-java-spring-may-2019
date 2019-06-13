package com.bootcamp.kata.controller.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ParticipateRequest {

    @NotNull(message = "Debe ingresar una puntuación para participar")
    @Max(value = 5000, message = "Debe ingresar un rango entre 0 y 5000")
    private int score;

    public ParticipateRequest() {
    }

    public ParticipateRequest(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipateRequest that = (ParticipateRequest) o;
        return score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
