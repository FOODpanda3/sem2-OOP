/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emsystem;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class Employee {
  
    // Attributes (fields)
    private String name;
    private int employeeId;
    private String department;
    private double monthlySalary;

    // Default Constructor (optional)
    public Employee() {
        // Provide default values if desired
        this.name = "Unknown";
        this.employeeId = 0;
        this.department = "None";
        this.monthlySalary = 0.0;
    }

    // Parameterized Constructor
    public Employee(String name, int employeeId, String department, double monthlySalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.monthlySalary = monthlySalary;
    }

    // Method to display employee details
    public void displayEmployeeInfo() {
        System.out.println("Employee Information:");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Monthly Salary: $" + monthlySalary);
  System.out.println("Annual Salary: $" + calculateAnnualSalary());
        System.out.println("-----------------------------");
    }
  public double calculateAnnualSalary() {
        return monthlySalary * 12;
    }

    // (Optional) Getter and Setter methods for further practice
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
