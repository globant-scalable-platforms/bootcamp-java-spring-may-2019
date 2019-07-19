package springbootcamp.springrest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import springbootcamp.springrest.controllers.exception.ChallengeForbiddenException;
import springbootcamp.springrest.controllers.exception.ChallengePreconditionFailedException;

import java.io.IOException;


@ControllerAdvice(annotations = RestController.class)

public class ChallengeExceptionController {

    @ExceptionHandler(value = ChallengePreconditionFailedException.class)
    public ResponseEntity<Object> preconditionException(ChallengePreconditionFailedException exception) {
        return new ResponseEntity<>("toDate is lower than fromDate", HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(value = ChallengeForbiddenException.class)
    public ResponseEntity<Object> forbiddenException(ChallengeForbiddenException exception) {
        return new ResponseEntity<>("You don't have permission to access on this server", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> internalServerException(Exception exception) {
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
