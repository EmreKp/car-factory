package com.assessment.cars.service;

import com.assessment.cars.factory.CarFactory;
import com.assessment.cars.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    public String handle(String type) {
        Car car = CarFactory.create(type);

        return String.format("%s Car has produced.", car.getType());
    }
}
