package com.bootcamp.restchallenge.controller.model.datevalidation;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class DateValidationRequest {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date from;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date to;

    public DateValidationRequest() {
    }

    public DateValidationRequest(Date from, Date to) {
        this.from = from;
        this.to = to;
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
}
