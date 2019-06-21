package com.bootcamp.restchallenge.data;

import com.bootcamp.restchallenge.exception.InvalidNumericCSVFileData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NumericCSVFileToListInterface {
    List<Integer> transformCSV(MultipartFile file) throws InvalidNumericCSVFileData;
}
