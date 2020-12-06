package com.assessment.cars.factory;

import com.assessment.cars.exception.UnsupportedTypeException;
import com.assessment.cars.model.Car;
import com.assessment.cars.model.CarEnum;

public class CarFactory {

    public static Car create(String type) {
        if (type == null) {
            throw new NullPointerException("Please specify a car type.");
        }

        for (CarEnum carEnum : CarEnum.values()) {
            if (type.equalsIgnoreCase(carEnum.getName())) {
                return carEnum.getCar();
            }
        }

        throw new UnsupportedTypeException(type);
    }
}
