package com.assessment.cars.model.response;

import com.assessment.cars.model.Response;

public class ErrorResponse implements Response {

    private String error;

    public String getError() {
        return error;
    }

    public ErrorResponse setError(String error) {
        this.error = error;

        return this;
    }
}
