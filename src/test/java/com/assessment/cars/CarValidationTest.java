package com.assessment.cars;

import com.assessment.cars.exception.UnsupportedTypeException;
import com.assessment.cars.validation.CarValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarValidationTest {

    private CarValidation validation;

    @BeforeEach
    public void init() {
        validation = new CarValidation();
    }

    @Test
    public void success() {
        boolean exceptionState = false;

        try {
            validation.validate("CaBRio");
        } catch (Exception ex) {
            exceptionState = true;
        }

        assert !exceptionState;
    }

    @Test
    public void type_unsupported() {
        boolean exceptionState = false;

        try {
            validation.validate("foo");
        } catch (Exception ex) {
            assert ex instanceof UnsupportedTypeException;

            exceptionState = true;
        }

        assert exceptionState;
    }
}
