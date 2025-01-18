package com.example.repository;

import com.example.model.Car;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, String> {
    @Query("SELECT COUNT(*) FROM cars WHERE brand = :brand")
    int countByBrand(String brand);

    @Query("SELECT * FROM cars WHERE kilometers < 100000")
    List<Car> findByKilometersLessThan();

    @Query("SELECT * FROM cars WHERE year > YEAR(CURDATE()) - 5")
    List<Car> findCarsNewerThanFiveYears();
}
