package com.dissident.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<GenericExceptionResponse> entityNotFoundExeception(EntityNotFoundException ex){
        return new ResponseEntity<>(new GenericExceptionResponse("Entity Not Found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ObjectOptimisticLockingFailureException.class)
    public ResponseEntity<GenericExceptionResponse> optimisticLockingFailureException(ObjectOptimisticLockingFailureException ex){
        return new ResponseEntity<>(new GenericExceptionResponse("Optimistic Locking Exception"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DataAccessException.class)
    public ResponseEntity<GenericExceptionResponse> dataAccessException(){
        return new ResponseEntity<>(new GenericExceptionResponse("Unable to save resource(s)"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
