package com.assessment.cars.model;

import com.assessment.cars.model.car.Cabrio;
import com.assessment.cars.model.car.Hatchback;
import com.assessment.cars.model.car.Sedan;

public enum CarEnum {

    CABRIO("Cabrio", new Cabrio()),
    SEDAN("Sedan", new Sedan()),
    HATCHBACK("Hatchback", new Hatchback());

    private final String name;
    private final Car car;

    CarEnum(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }
}
