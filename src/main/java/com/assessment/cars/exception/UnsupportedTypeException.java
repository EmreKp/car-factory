package com.assessment.cars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UnsupportedTypeException extends ResponseStatusException {

    public UnsupportedTypeException(String type) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, String.format("Invalid type: %s", type));
    }
}
