package com.assessment.cars;

import com.assessment.cars.exception.UnsupportedTypeException;
import com.assessment.cars.factory.CarFactory;
import com.assessment.cars.model.car.Cabrio;
import com.assessment.cars.model.Car;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    public void cabrio() {
        Car car = CarFactory.create("cabrio");

        assert car instanceof Cabrio;
    }

    @Test
    public void type_null() {
        boolean exceptionState = false;

        try {
            Car car = CarFactory.create(null);
        } catch (Exception ex) {
            assert ex instanceof NullPointerException;

            exceptionState = true;
        }

        assert exceptionState; // Assert if it is true.
    }

    @Test
    public void unsupported_type() {
        boolean exceptionState = false;

        try {
            Car car = CarFactory.create("foo");
        } catch (Exception ex) {
            assert ex instanceof UnsupportedTypeException;

            exceptionState = true;
        }

        assert exceptionState; // Assert if it is true.
    }
}
