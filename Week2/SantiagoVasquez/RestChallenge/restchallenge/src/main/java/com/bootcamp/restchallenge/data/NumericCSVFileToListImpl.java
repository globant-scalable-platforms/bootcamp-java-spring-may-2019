package com.bootcamp.restchallenge.data;

import com.bootcamp.restchallenge.exception.InvalidNumericCSVFileData;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumericCSVFileToListImpl implements NumericCSVFileToListInterface {

    @Override
    public List<Integer> transformCSV(MultipartFile file) throws InvalidNumericCSVFileData {
        try {
            return new BufferedReader(new InputStreamReader(file.getInputStream()))
                    .lines()
                    .map(w -> w.split(","))
                    .flatMap(Arrays::stream)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new InvalidNumericCSVFileData();
        }

    }
}
