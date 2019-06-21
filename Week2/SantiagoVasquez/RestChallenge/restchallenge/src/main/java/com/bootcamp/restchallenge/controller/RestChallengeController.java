package com.bootcamp.restchallenge.controller;

import com.bootcamp.restchallenge.controller.interceptor.RolesHeaderValidator;
import com.bootcamp.restchallenge.controller.model.datevalidation.DateValidationRequest;
import com.bootcamp.restchallenge.controller.model.datevalidation.DateValidationResponse;
import com.bootcamp.restchallenge.controller.model.headervalidation.HeaderResponse;
import com.bootcamp.restchallenge.controller.model.numbers.NumbersResponse;
import com.bootcamp.restchallenge.data.DateValidationInterface;
import com.bootcamp.restchallenge.data.NumericCSVFileToListInterface;
import com.bootcamp.restchallenge.data.NumericControllerInterface;
import com.bootcamp.restchallenge.data.StudentsControllerInterface;
import com.bootcamp.restchallenge.domain.Student;
import com.bootcamp.restchallenge.exception.IncorrectDateException;
import com.bootcamp.restchallenge.exception.InvalidNumericCSVFileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/challenge")
public class RestChallengeController {

    @Autowired
    @Qualifier(value = "dateOperation")
    private DateValidationInterface dateValidation;

    @Autowired
    @Qualifier(value = "numericController")
    private NumericControllerInterface numericController;

    @Autowired
    @Qualifier(value = "numericCSVFileToList")
    private NumericCSVFileToListInterface numericCSVFileToList;

    @Autowired
    @Qualifier(value = "studentsController")
    private StudentsControllerInterface studentsController;

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

    @PostMapping(path = "/numbers", consumes = {"multipart/form-data;charset=UTF-8"})
    public NumbersResponse handleNumberFile(@RequestParam("file") MultipartFile file) throws InvalidNumericCSVFileData {
        final List<Integer> integerList = numericCSVFileToList.transformCSV(file);

        NumbersResponse response = new NumbersResponse();
        response.setAverage(numericController.average(integerList));
        response.setCount(numericController.count(integerList));
        response.setMax(numericController.max(integerList));
        response.setMin(numericController.min(integerList));
        response.setSum(numericController.sum(integerList));

        return response;
    }

    @GetMapping(path = "/students")
    public List<Student> getStudents(@RequestParam(required = false) String name, @RequestParam(required = false) String identification, @RequestParam(required = false) Integer age) {
        return studentsController.getStudents(name, identification, age);
    }
}
