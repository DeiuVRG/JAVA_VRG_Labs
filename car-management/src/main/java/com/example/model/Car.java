package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("cars")
public class Car {
    @Id
    private String licensePlate;
    private String brand;
    private int year;
    private String color;
    private int kilometers;

    // Getters and Setters
}
