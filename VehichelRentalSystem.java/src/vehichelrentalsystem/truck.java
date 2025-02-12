package vehichelrentalsystem;

public class truck extends Vehicle {
    private double payloadCapacity;
    
    // Constructor override: calls super constructor and initializes payloadCapacity
    public truck(String make, String model, double rentalPrice, double payloadCapacity) {
        super(make, model, rentalPrice);
        this.payloadCapacity = payloadCapacity;
    }
    
    // Method override: extend displayDetails to include payloadCapacity
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Payload Capacity: " + payloadCapacity + " tons");
    }

    // ✅ Overridden method to apply an extra 5% discount for rentals over 3 days
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
        System.out.println("Checking payload systems and engine oil for the truck.");
    }
}
