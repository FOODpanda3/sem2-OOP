/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehichelrentalsystem;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class electricCar extends Vehicle {
     private int numberOfDoors;
     double kWh;
    public electricCar(String make, String model, double rentalPrice, int par1 , double kWh) {
        super(make, model, rentalPrice);
         this.numberOfDoors = numberOfDoors;
         this.kWh = kWh;
    }
     @Override
    public void displayDetails() {
        super.displayDetails();  // Call Vehicle's displayDetails
        System.out.println("Number of Doors: " + numberOfDoors);
          System.out.println("Batery Capacity: " + kWh);
    }
     @Override
    public double calculateDiscountedRentalCost(int days, double discountPercentage) {
        double totalCost = super.calculateDiscountedRentalCost(days, discountPercentage);
        
        // Extra 5% discount if rental period is more than 3 days
        if (days > 3) {
            double extraDiscount = totalCost * 0.05;
            totalCost -= extraDiscount;
        }
        
        return totalCost;
    }
    @Override
    public void performMaintenance() {
        System.out.println("Checking battery health and charging system.");
    }
}