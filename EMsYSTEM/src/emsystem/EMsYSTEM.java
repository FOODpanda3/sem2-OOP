/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package emsystem;

/**
 *
 * @author VILLACORTA_CpE121
 */
public class EMsYSTEM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Employee emp1 = new Employee("Alice Johnson", 1001, "Human Resources", 4500.0);
        Employee emp2 = new Employee("Bob Smith", 1002, "Engineering", 6000.0);
        Employee emp3 = new Employee("Carol White", 1003, "Marketing", 5000.0);

 emp1.displayEmployeeInfo();
        emp2.displayEmployeeInfo();
        emp3.displayEmployeeInfo();

    }
    
}
