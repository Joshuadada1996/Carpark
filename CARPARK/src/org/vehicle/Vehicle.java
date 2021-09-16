package org.vehicle;

import java.util.Date;

public abstract class Vehicle {

    public Vehicle(String idPlate, String make, Date date) {
        this.idPlate = idPlate;
        this.date = date;
        this.make = make;
    }

    private Date date;
    private String idPlate;
    private String make;

    public String getIdPlate() {
        return idPlate;
    }

    public String getMake() {
        return make;
    }

    public Date getDate() {
        return date;
    }

}