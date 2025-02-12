/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehichelrentalsystem;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class MotorCycle extends Vehicle {
    private boolean hasHelmetRental;
    
    // Constructor override: calls super constructor and initializes hasHelmetRental
    public MotorCycle(String make, String model, double rentalPrice, boolean hasHelmetRental) {
        super(make, model, rentalPrice);
        this.hasHelmetRental = hasHelmetRental;
    }
    
    // Method override: extend displayDetails to include helmet rental info
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Helmet Rental Available: " + (hasHelmetRental ? "Yes" : "No"));
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
        System.out.println("Inspecting brakes and tire pressure for the motorcycle.");
    }
}