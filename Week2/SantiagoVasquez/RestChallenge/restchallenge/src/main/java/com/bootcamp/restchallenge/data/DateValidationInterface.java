package com.bootcamp.restchallenge.data;

import com.bootcamp.restchallenge.exception.IncorrectDateException;

import java.util.Date;

public interface DateValidationInterface {
    boolean isValid(Date from, Date to) throws IncorrectDateException;
}
