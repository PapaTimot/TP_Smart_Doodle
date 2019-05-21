package esir.tp.doodle.jpa.controller;

import esir.tp.doodle.jpa.exception.PollNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PollNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PollNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pollNotFoundHandler(PollNotFoundException ex) {
        return ex.getMessage();
    }
}
