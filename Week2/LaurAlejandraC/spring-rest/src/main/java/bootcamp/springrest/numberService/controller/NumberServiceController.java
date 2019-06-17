package bootcamp.springrest.numberService.controller;

import bootcamp.springrest.numberService.data.NumberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/number-service")
public class NumberServiceController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NumberRepository> processFile(@RequestParam("file") MultipartFile file){
        NumberRepository numberRepository = new NumberRepository();
        HttpStatus response = numberRepository.initializeFromFile(file);

        return new ResponseEntity<>(numberRepository, response);
    }
}
