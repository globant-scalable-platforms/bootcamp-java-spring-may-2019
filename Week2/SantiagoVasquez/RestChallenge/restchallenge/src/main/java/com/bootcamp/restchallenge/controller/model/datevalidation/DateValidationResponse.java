package com.bootcamp.restchallenge.controller.model.datevalidation;

import java.util.Date;

public class DateValidationResponse {

    private Date from;
    private Date to;
    private boolean result;

    public DateValidationResponse() {
    }

    public DateValidationResponse(Date from, Date to, boolean result) {
        this.from = from;
        this.to = to;
        this.result = result;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
