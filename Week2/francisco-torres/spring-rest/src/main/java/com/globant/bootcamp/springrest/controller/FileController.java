package com.globant.bootcamp.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileController {

    @GetMapping
    public ResponseEntity<IntSummaryStatistics> validateFile(@RequestHeader("file") MultipartFile file) throws IOException {
        String[] fileNumbers = new String(file.getBytes()).split(",");

        List<Integer> listNumbers = Arrays.stream(fileNumbers)
                .map(a -> Integer.parseInt(a.trim()))
                .collect(Collectors.toList());

        IntSummaryStatistics stats = listNumbers.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}
