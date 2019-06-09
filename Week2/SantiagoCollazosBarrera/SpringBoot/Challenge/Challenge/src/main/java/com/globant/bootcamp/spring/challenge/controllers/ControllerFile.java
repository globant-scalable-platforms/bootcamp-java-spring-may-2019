/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.spring.challenge.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Santiago Collazos Barrera
 */
@RestController()
@RequestMapping("/file")
public class ControllerFile {

    @PostMapping()
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) throws IOException {
        
        String line;
        
        Stream<String> lines = Files.lines(Paths.get(file.getOriginalFilename()));
        line = getElements(lines.iterator());

        List<Integer> values = Stream.of(line.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
                
        IntSummaryStatistics stats = values.stream()
                                     .mapToInt((x) -> x)
                                     .summaryStatistics();
        
        return ResponseEntity.status(HttpStatus.OK).body(stats);

    }

    private String getElements(Iterator<String> iterator) {
        List<Integer> values = new ArrayList();
        Iterable<String> iterable = () -> iterator;

        // Create a List from the Iterable 
        List<String> list = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        // Return the List 
        return list.get(0);
    }

}
