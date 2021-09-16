package org.vehicle.impl;

import org.vehicle.Vehicle;

import java.util.Date;

public class Van extends Vehicle {

    public Van(String idPlate, String make, Date date, String cargo) {
        super(idPlate, make, date);
        this.cargo = cargo;
    }

    private String cargo;

}