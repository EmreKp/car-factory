package com.assessment.cars.model.response;

import com.assessment.cars.model.Response;

public class SuccessResponse implements Response {

    private String result;

    public String getResult() {
        return result;
    }

    public SuccessResponse setResult(String result) {
        this.result = result;

        return this;
    }
}
