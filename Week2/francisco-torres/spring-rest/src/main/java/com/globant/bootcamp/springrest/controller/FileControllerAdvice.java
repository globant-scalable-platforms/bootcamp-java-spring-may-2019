package com.globant.bootcamp.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice(assignableTypes = FileController.class)
public class FileControllerAdvice {

    @ExceptionHandler(IOException.class)
    public ResponseEntity IOException(final IOException e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("there is problems to read the file.");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity NullPointerException(final NullPointerException e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("there is not upload file.");
    }
}
