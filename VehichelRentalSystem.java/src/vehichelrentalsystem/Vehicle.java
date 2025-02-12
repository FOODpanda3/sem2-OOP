package vehichelrentalsystem;

public abstract class Vehicle {
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

    // ✅ Added method to calculate discounted rental cost
    public double calculateDiscountedRentalCost(int days, double discountPercentage) {
        double totalCost = calculateRentalCost(days);
        double discountAmount = totalCost * (discountPercentage / 100);
        return totalCost - discountAmount;
    }
    public abstract void performMaintenance();
}
