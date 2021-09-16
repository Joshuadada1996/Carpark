package org;

import org.vehicle.impl.Car;
import org.vehicle.impl.Motorbike;
import org.vehicle.impl.Van;
import org.vehicle.Vehicle;

import java.util.*;

public class WestminsterCarParkManager implements CarParkManager {

    private final int MAXIMUM_PARKING_SLOTS = 20;
    private List<Vehicle> parkedVehicles = new LinkedList<>();

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (getParkingSlots(vehicle) > MAXIMUM_PARKING_SLOTS) {
            System.out.println("There are no parking slots available.");
            return;
        }
        getParkedVehicles().add(vehicle);
        System.out.println("Vehicle has been added to the car park.");
    }

    @Override
    public void removeVehicle(String plate) {
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getIdPlate().equalsIgnoreCase(plate)) {
                parkedVehicles.remove(vehicle);
                System.out.println(vehicle instanceof Car ? "There is a car leaving the car park." : vehicle instanceof Van ? "There is a van leaving th car park." : vehicle instanceof Motorbike ? "There is a motorbike leaving the car park." : "No specified vehicle leaving the car park.");
                break;
            }
        }
    }

    @Override
    public void parkedVehicles() {
        int count = 0;
        System.out.println("");
        System.out.println("The cars parked inside are currently the following:");

        List<Vehicle> duplicate = new LinkedList<>();
        duplicate.clear();
        duplicate.addAll(parkedVehicles);
        Collections.reverse(duplicate);

        for (Vehicle vehicle : parkedVehicles) {
            if (Objects.nonNull(vehicle)) {
                String type = vehicle instanceof Car ? "Car" : vehicle instanceof Van ? "Van" : vehicle instanceof Motorbike ? "Motorbike" : "N/A";
                System.out.println("Id Plate: " + vehicle.getIdPlate() + " Entry time: " + vehicle.getDate() + " Vehicle type: " + type);
                count++;
            }
        }
        System.out.println("");
        if (count == 0) {
            System.out.println("There are currently no vehicles inside of the car park.");
            System.out.println("");
        }
    }

    @Override
    public int getParkingSlots(Vehicle car) {
        int slots = MAXIMUM_PARKING_SLOTS;
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle instanceof Van || car instanceof Van) {
                slots -= 2;
            } else {
                slots -= 1;
            }
        }
        return slots;
    }

    @Override
    public void printParkingStats() {
        int total = MAXIMUM_PARKING_SLOTS;
        int cars = 0;
        int vans = 0;
        int motorbike = 0;
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle instanceof Van) {
                vans += 2;
            } else if (vehicle instanceof Car) {
                cars++;
            } else if (vehicle instanceof Motorbike) {
                motorbike++;
            }
        }

        if (cars != 0)
            cars = cars * 100 / total;
        if (vans != 0)
            vans = vans * 100 / total;
        if (motorbike != 0)
            motorbike = motorbike * 100 / total;

        System.out.println("Cars: " + cars  + "% Vans: " + vans + "% Motorbike: " + motorbike + "%");
    }

    public void searchDate(int day, int month, int year) {
        boolean found = false;
        for (Vehicle vehicle : parkedVehicles) {
            if (Objects.nonNull(vehicle)) {
//                System.out.println(vehicle.getDate().getDate() + " : " + vehicle.getDate().getMonth() + " : " + vehicle.getDate().getYear());
//                if (date.getDate() == day) {
//                    System.out.println(vehicle.getIdPlate() + " was parked on that date.");
//                    found = true;
//                }
            }
        }
        if (!found)
            System.out.println("no vehicles found on that date.");
    }

    public List<Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }

}