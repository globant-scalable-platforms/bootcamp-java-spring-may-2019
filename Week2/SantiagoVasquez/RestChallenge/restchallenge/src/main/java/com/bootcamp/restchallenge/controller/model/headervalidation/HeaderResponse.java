package com.bootcamp.restchallenge.controller.model.headervalidation;

public class HeaderResponse {

    private boolean valid;

    public HeaderResponse() {
    }

    public HeaderResponse(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
