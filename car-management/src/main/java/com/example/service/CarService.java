package com.example.service;

import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(String licensePlate) {
        carRepository.deleteById(licensePlate);
    }

    public Car findCar(String licensePlate) {
        return carRepository.findById(licensePlate).orElse(null);
    }

    public List<Car> findAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public int countByBrand(String brand) {
        return carRepository.countByBrand(brand);
    }

    public List<Car> findCarsWithLowKilometers() {
        return carRepository.findByKilometersLessThan();
    }

    public List<Car> findCarsNewerThanFiveYears() {
        return carRepository.findCarsNewerThanFiveYears();
    }
}
