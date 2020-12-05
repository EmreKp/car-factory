package com.assessment.cars.controller;

import com.assessment.cars.model.response.SuccessResponse;
import com.assessment.cars.service.CarService;
import com.assessment.cars.validation.CarValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

    private final CarValidation validation;
    private final CarService service;

    @Autowired
    public CarController(CarValidation validation, CarService service) {
        this.validation = validation;
        this.service = service;
    }

    @GetMapping("/")
    public @ResponseBody
    ResponseEntity<SuccessResponse> invoke(@RequestParam String type) {
        validation.validate(type);

        SuccessResponse response = new SuccessResponse().setResult(service.handle(type));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
