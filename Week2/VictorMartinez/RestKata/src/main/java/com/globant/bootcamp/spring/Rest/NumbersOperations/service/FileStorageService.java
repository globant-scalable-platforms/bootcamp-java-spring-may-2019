package com.globant.bootcamp.spring.Rest.NumbersOperations.service;

import com.globant.bootcamp.spring.Rest.NumbersOperations.Exception.FileStorageException;
import com.globant.bootcamp.spring.Rest.NumbersOperations.Exception.MyFileNotFoundException;
import com.globant.bootcamp.spring.Rest.NumbersOperations.property.FileStorageProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties){
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);

        }catch(Exception es){
            throw new FileStorageException("Could not create the directory for storaging the files");
        }
    }

    public String storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Wrong Filename");
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return  fileName;
        }catch(IOException ex){
            throw new FileStorageException("Could not store file"+fileName+". Please, try again", ex);
        }
    }

    public Resource loadFileAsResource(String fileName){
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found" + fileName);
            }
        }
            catch(MalformedURLException ex){
                throw new MyFileNotFoundException("File not found "+ fileName, ex);
            }
    }
}


