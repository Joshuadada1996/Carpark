package org;

import org.vehicle.Vehicle;

public interface CarParkManager {

    public void addVehicle(Vehicle vehicle);

    public void removeVehicle(String plate);

    public void parkedVehicles();

    public int getParkingSlots(Vehicle car);

    public void printParkingStats();

//    public void searchDate();

}