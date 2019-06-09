package com.bootcamp.restchallenge.controller;

import com.bootcamp.restchallenge.controller.interceptor.RolesHeaderValidator;
import com.bootcamp.restchallenge.controller.model.datevalidation.DateValidationRequest;
import com.bootcamp.restchallenge.controller.model.datevalidation.DateValidationResponse;
import com.bootcamp.restchallenge.controller.model.headervalidation.HeaderResponse;
import com.bootcamp.restchallenge.data.DateValidationInterface;
import com.bootcamp.restchallenge.exception.IncorrectDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/challenge")
public class RestChallengeController {

    @Autowired
    @Qualifier(value = "dateOperation")
    private DateValidationInterface dateValidation;

    /**
     * Given a date range input (from, to), validate that to date is greater than from date,
     * return an exception otherwise
     *
     * @param request
     * @return
     * @throws IncorrectDateException
     */
    @PostMapping(path = "/date/validation")
    public DateValidationResponse dateValidation(@RequestBody @Valid DateValidationRequest request) throws IncorrectDateException {
        final boolean isValid = dateValidation.isValid(request.getFrom(), request.getTo());
        return new DateValidationResponse(request.getFrom(), request.getTo(), isValid);
    }

    /**
     * Create a service that validates that a header called “roles” contains the “admin”
     * role, otherwise return forbidden http status code
     */
    @GetMapping(path = "/header/validation")
    @RolesHeaderValidator
    public HeaderResponse headerValidation() {
        return new HeaderResponse(true);
    }
}
