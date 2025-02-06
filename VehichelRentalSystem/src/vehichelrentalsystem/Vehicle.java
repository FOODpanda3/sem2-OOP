/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehichelrentalsystem;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class Vehicle {
    protected String make;
    protected String model;
    protected double rentalPrice;
    
    // Constructor to initialize common attributes
    public Vehicle(String make, String model, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.rentalPrice = rentalPrice;
    }
    
    // Method to display basic vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Details:");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Rental Price per Day: $" + rentalPrice);
    }
    
    // Method to calculate rental cost for a given number of days
    public double calculateRentalCost(int days) {
        return rentalPrice * days;
    }

}
