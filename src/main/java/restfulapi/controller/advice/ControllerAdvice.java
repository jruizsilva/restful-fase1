package restfulapi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import restfulapi.controller.advice.exception.LocalNotFound;
import restfulapi.controller.advice.response.ErrorMessage;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(LocalNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> localNotFound(LocalNotFound e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(errorMessage);
    }
}


