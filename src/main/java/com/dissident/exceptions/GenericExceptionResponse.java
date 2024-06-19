package com.dissident.exceptions;

import lombok.Data;

@Data
public class GenericExceptionResponse {
    private String message;

    public GenericExceptionResponse(String message) {
        this.message = message;
    }
}
