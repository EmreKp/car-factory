package com.assessment.cars.exception.handler;

import com.assessment.cars.model.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request
    ) {
        String errorMessage = ex.getMessage();

        if (ex.getParameterName().equals("type")) {
            errorMessage = "Please specify a car type";
        }

        ErrorResponse response = new ErrorResponse().setError(errorMessage);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public @ResponseBody
    ResponseEntity<ErrorResponse> handleStatusException(ResponseStatusException ex) {
        ErrorResponse response = new ErrorResponse().setError(ex.getReason());

        return new ResponseEntity<>(response, ex.getStatus());
    }
}
