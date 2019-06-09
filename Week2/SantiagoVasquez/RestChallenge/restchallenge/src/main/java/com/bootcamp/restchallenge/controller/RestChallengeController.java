package com.bootcamp.restchallenge.controller;

import com.bootcamp.restchallenge.controller.model.DateOperationRequest;
import com.bootcamp.restchallenge.controller.model.DateOperationResponse;
import com.bootcamp.restchallenge.data.DateValidationInterface;
import com.bootcamp.restchallenge.exception.IncorrectDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/challenge")
public class RestChallengeController {

    @Autowired
    @Qualifier(value = "dateOperation")
    private DateValidationInterface dateValidation;

    @PostMapping(path = "/date/validation")
    public DateOperationResponse dateValidation(@RequestBody @Valid DateOperationRequest request) throws IncorrectDateException {
        final boolean isValid = dateValidation.isValid(request.getFrom(), request.getTo());
        return new DateOperationResponse(request.getFrom(), request.getTo(), isValid);
    }
}
