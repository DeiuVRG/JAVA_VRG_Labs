package com.example.controller;

import com.example.model.Car;
import com.example.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class MainController {
    private final CarService carService;

    public MainController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.addCar(car);
    }

    @DeleteMapping("/{licensePlate}")
    public void deleteCar(@PathVariable String licensePlate) {
        carService.deleteCar(licensePlate);
    }

    @GetMapping("/{licensePlate}")
    public Car getCar(@PathVariable String licensePlate) {
        return carService.findCar(licensePlate);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/count/{brand}")
    public int countByBrand(@PathVariable String brand) {
        return carService.countByBrand(brand);
    }

    @GetMapping("/low-kilometers")
    public List<Car> findLowKilometerCars() {
        return carService.findCarsWithLowKilometers();
    }

    @GetMapping("/newer")
    public List<Car> findNewerCars() {
        return carService.findCarsNewerThanFiveYears();
    }
}
