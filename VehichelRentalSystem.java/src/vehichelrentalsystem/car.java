/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehichelrentalsystem;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class car extends Vehicle {
       private int numberOfDoors;
    
    // Constructor override: calls super constructor and initializes numberOfDoors
    public car(String make, String model, double rentalPrice, int numberOfDoors) {
        super(make, model, rentalPrice);
        this.numberOfDoors = numberOfDoors;
    }
    
    // Method override: extend displayDetails to include numberOfDoors
    @Override
    public void displayDetails() {
        super.displayDetails();  // Call Vehicle's displayDetails
        System.out.println("Number of Doors: " + numberOfDoors);
    }
 @Override
    public double calculateDiscountedRentalCost(int days, double discountPercentage) {
        double totalCost = super.calculateDiscountedRentalCost(days, discountPercentage);
        
        // Extra 5% discount if rental period is more than 3 days
        if (days > 4) {
            double extraDiscount = totalCost * 0.05;
            totalCost -= extraDiscount;
        }
        
        return totalCost;
    }
    @Override
    public void performMaintenance() {
        System.out.println("Performing general car maintenance.");
    }
}