package com.globant.bootcamp.spring.Rest.NumbersOperations.Controller;
import com.globant.bootcamp.spring.Rest.NumbersOperations.Data.NumbersDataSource;
import com.globant.bootcamp.spring.Rest.NumbersOperations.property.FileStorageProperties;
import jdk.internal.loader.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.globant.bootcamp.spring.Rest.NumbersOperations.Controller.Utils.convertInputStream2String;

@RestController
public class NumbersController {

    private static final Logger logger = LoggerFactory.getLogger(NumbersController.class);
    @Autowired
    private FileStorageProperties fileStorageProperties;

    @PostMapping("/uploadFile")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {

        String incomingMessage = convertInputStream2String(file);
        try {
            NumbersDataSource numbersDataSource = new NumbersDataSource(incomingMessage.split(","));
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                    .body(numbersDataSource);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
                    .body(null);
        }

    }


    /*
    @PostMapping("/uploadMultipleFile")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }*/

    /*
    @GetMapping("/downloadFle/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Resource resource = fileStorageProperties.loadFileAsResource(filename);

        String contentType = null;

        try{
            contentType = request.getServletContext().getMimeType(resource.getInputStream().toString());

        }catch(IOException ex){
            logger.info("Could not determine file type");
        }

        if(contentType == null){
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ resource.getName()+"\"")
                .body(resource);
    }*/



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greeting(){
        return "Numbers Practice";
    }

}
