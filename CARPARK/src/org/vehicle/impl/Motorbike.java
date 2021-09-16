package org.vehicle.impl;

import org.vehicle.Vehicle;

import java.util.Date;

public class Motorbike extends Vehicle {

    public Motorbike(String idPlate, String make, Date date, int engineSize) {
        super(idPlate, make, date);
        this.engineSize = engineSize;
    }

    private int engineSize;

}