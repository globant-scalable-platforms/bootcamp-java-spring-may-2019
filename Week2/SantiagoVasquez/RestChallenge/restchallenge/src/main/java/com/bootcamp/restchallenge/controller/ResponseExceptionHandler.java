package com.bootcamp.restchallenge.controller;

import com.bootcamp.restchallenge.controller.model.ApiError;
import com.bootcamp.restchallenge.exception.HeaderValidationException;
import com.bootcamp.restchallenge.exception.IncorrectDateException;
import com.bootcamp.restchallenge.exception.IncorrectFormatDateException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler({
            IncorrectFormatDateException.class,
            IncorrectDateException.class,
            HttpMessageNotReadableException.class,
            HeaderValidationException.class,
    })
    public final ResponseEntity<ApiError> dateOperationIncorrectDateExceptionHandler(Exception exception, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();

        System.out.println(exception);

        if (exception instanceof IncorrectFormatDateException) {
            return handleExceptionInternal(exception, new ApiError("Incorrect date format"), headers, HttpStatus.BAD_REQUEST, request);
        } else if (exception instanceof IncorrectDateException) {
            return handleExceptionInternal(exception, new ApiError("From date must be less than to date"), headers, HttpStatus.BAD_REQUEST, request);
        } else if (exception instanceof HttpMessageNotReadableException) {
            return handleExceptionInternal(exception, new ApiError("Missing arguments"), headers, HttpStatus.BAD_REQUEST, request);
        } else if (exception instanceof HeaderValidationException) {
            return handleExceptionInternal(exception, null, headers, HttpStatus.FORBIDDEN, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(exception, null, headers, status, request);
        }
    }

    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}
