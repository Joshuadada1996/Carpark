package org.vehicle.impl;

import org.vehicle.Vehicle;

import java.util.Date;

public class Car extends Vehicle {

    public Car(String idPlate, String make, Date date, int doors, String color) {
        super(idPlate, make, date);
        this.doors = doors;
        this.color = color;
    }

    private int doors;
    private String color;

}