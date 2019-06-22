package com.bootcamp.restapp.RestExample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

@RestController
public class ExternalFileController {

    private Stream<Integer> numberStream;


    @RequestMapping(value="/upload", method= RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> readExternalFile(@RequestParam("file") MultipartFile file) throws IOException {

        List<String> stringList = new ArrayList<>();

        Scanner scanner = new Scanner(file.getInputStream());

        while(scanner.hasNextLine()){
            String[] splittedLine = scanner.nextLine().split(",");

            stringList.addAll(Arrays.asList(splittedLine));
        }

        scanner.close();

        String dataAnalysis = analizeStream(stringList);

        return new ResponseEntity<>(dataAnalysis, HttpStatus.OK);
    }//End of readExternalFile

    private String analizeStream(List<String> stringList){

        long count = getCount(stringList);

        long sum = getSum(stringList);

        double average = getAverage(stringList);

        int max = getMax(stringList);

        int min = getMin(stringList);

        return "Data Analysis:\n" + "Count: " + count + "\n" +
                                    "Sum: " + sum + "\n" +
                                    "Min Value: " + min + "\n" +
                                    "Max Value: " + max + "\n" +
                                    "Average: " + average + "\n";
    }

    private long getCount(List<String> stringList){
        return stringList.stream().count();
    }

    private long getSum(List<String> stringList){
        return stringList.stream()
                        .mapToInt(Integer::parseInt)
                        .sum();
    }

    private double getAverage(List<String> stringList){
        return stringList.stream()
                        .mapToInt(Integer::parseInt)
                        .average()
                        .getAsDouble();
    }

    private int getMax(List<String> stringList){
        return stringList.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
    }

    private int getMin(List<String> stringList){
        return stringList.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();
    }
}
