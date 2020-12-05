package com.assessment.cars.validation;

import com.assessment.cars.exception.UnsupportedTypeException;
import com.assessment.cars.model.CarEnum;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CarValidation {

    // Null checking is done in Spring core level, so validation method never gets a null value.
    public void validate(String type) {

        if (Arrays.stream(CarEnum.values()).noneMatch(carEnum -> type.equalsIgnoreCase(carEnum.getName()))) {
            throw new UnsupportedTypeException(type);
        }
    }
}
