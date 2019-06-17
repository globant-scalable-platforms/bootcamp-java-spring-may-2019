package com.bootcamp.restchallenge.data;


import com.bootcamp.restchallenge.exception.IncorrectDateException;

import java.util.Date;

public class DateValidationImpl implements DateValidationInterface {
    @Override
    public boolean isValid(Date from, Date to) throws IncorrectDateException {
        if (from.getTime() > to.getTime()) {
            throw new IncorrectDateException();
        }
        return from.getTime() < to.getTime();
    }
}
