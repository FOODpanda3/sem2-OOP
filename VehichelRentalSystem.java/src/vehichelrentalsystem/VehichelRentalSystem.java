package vehichelrentalsystem;

public class VehichelRentalSystem {
    public static void main(String[] args) {
        // Create an array of Vehicle objects demonstrating polymorphism
        Vehicle[] vehicles = new Vehicle[4];
        
        vehicles[0] = new car("Toyota", "Camry", 50.0, 4);
        vehicles[1] = new truck("Ford", "F-150", 80.0, 2.5);
        vehicles[2] = new MotorCycle("Harley-Davidson", "Street 750", 40.0, true);
        vehicles[3] = new electricCar("Tesla", "Model S", 100.0, 2, 5000);
        
        int rentalDays = 5; // Set to 5 to test extra truck discount
        double discountPercentage = 10; // 10% discount
        
        // Loop through each vehicle and display rental cost with discount
        for (Vehicle v : vehicles) {
            v.displayDetails();
            System.out.println("Rental Cost for " + rentalDays + " days: $" + v.calculateRentalCost(rentalDays));
            
            
            System.out.println("Discounted Rental Cost for " + rentalDays + " days: $" + v.calculateDiscountedRentalCost(rentalDays, discountPercentage));
              v.performMaintenance();
            System.out.println("-----------------------------");
        }
    }
}
