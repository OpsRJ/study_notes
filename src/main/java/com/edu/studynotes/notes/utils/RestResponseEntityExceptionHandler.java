package com.edu.studynotes.notes.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
        return error(e, HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<String> error(EntityNotFoundException e, HttpStatus status) {
        log.error("Exception:. " + e.getMessage());
        return new ResponseEntity<>(e.getMessage(), status);
    }
}
