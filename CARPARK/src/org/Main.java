package org;

import org.vehicle.impl.Car;
import org.vehicle.impl.Motorbike;
import org.vehicle.impl.Van;

import java.util.Date;
import java.util.Scanner;

public class Main {

    private WestminsterCarParkManager carparkManager;

    public static void main(String[] args) {
        Main main = new Main();
        main.setCarparkManager(new WestminsterCarParkManager());
        main.runMenu();
    }

    public void runMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Car parking");
            System.out.println("A-Add the customer to the car park");
            System.out.println("D-Delete the customer from the car park");
            System.out.println("P-Available vehicles inside of the car park");
            System.out.println("K-Print stats");
            System.out.println("S-Search by date when a vehicle had entered the car park");
            System.out.println("E-Press E to Exit");

            String userInput = input.next();
            if (userInput.equals("A")){
                System.out.println("What type is of a vehicle is it? (Car, Van or Motorbike)?" ) ;
                String type = input.next();
                System.out.println("Enter the customer's id plate:" );
                String idPlate = input.next();
                System.out.println("Enter the model of the vehicle:" ) ;
                String model = input.next();
                Date date = new Date();
                if (type.equalsIgnoreCase("motorbike")) {
                    System.out.println("What is the engine size?") ;
                    int size = input.nextInt();
                    getCarparkManager().addVehicle(new Motorbike(idPlate, model, date, size));
                } else if (type.equalsIgnoreCase("car")) {
                    System.out.println("How many doors does the vehicle have?") ;
                    int doors = input.nextInt();
                    System.out.println("What color is the vehicle?") ;
                    String color = input.next();
                    getCarparkManager().addVehicle(new Car(idPlate, model, date, doors, color));
                } else if (type.equalsIgnoreCase("van")) {
                    System.out.println("What cargo is in the vehicle?") ;
                    String size = input.next();
                    getCarparkManager().addVehicle(new Van(idPlate, model, date, size));
                }
            }
            if (userInput.equals("D")) {
                System.out.println("What is the vehicle id plate?");
                String id = input.next();
                getCarparkManager().removeVehicle(id);
            }
            if (userInput.equals("P")) {
                getCarparkManager().parkedVehicles();
            }
            if (userInput.equals("K")) {
                getCarparkManager().printParkingStats();
            }
            if (userInput.equals("S")) {

            }
            if (userInput.equals("E")) {
                System.exit(0);
            }
        }
    }

    public void setCarparkManager(WestminsterCarParkManager carparkManager) {
        this.carparkManager = carparkManager;
    }

    public WestminsterCarParkManager getCarparkManager() {
        return carparkManager;
    }

}