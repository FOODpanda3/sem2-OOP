/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehichelrentalsystem;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class VehichelRentalSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an array of Vehicle objects demonstrating polymorphism
        Vehicle[] vehicles = new Vehicle[4];
        
        vehicles[0] = new car("Toyota", "Camry", 50.0, 4);
        vehicles[1] = new truck("Ford", "F-150", 80.0, 2.5);
        vehicles[2] = new MotorCycle("Harley-Davidson", "Street 750", 40.0, true);
        vehicles[3] = new electricCar ("Tesla", "Model S", 40.0, 2, 5000);
        
        int rentalDays = 3;
        // Loop through each vehicle and display its details and rental cost
        for (Vehicle v : vehicles) {
            v.displayDetails();
            System.out.println("Rental Cost for " + rentalDays + " days: $" + v.calculateRentalCost(rentalDays));
            System.out.println("-----------------------------");
        }
    }

    }
    

