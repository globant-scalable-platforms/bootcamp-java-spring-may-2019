package com.bootcamp.restchallenge.controller.model.numbers;

import org.springframework.web.multipart.MultipartFile;

public class NumbersRequest {
    private MultipartFile file;

    public NumbersRequest() {
    }

    public NumbersRequest(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
