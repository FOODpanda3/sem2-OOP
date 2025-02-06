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

}
