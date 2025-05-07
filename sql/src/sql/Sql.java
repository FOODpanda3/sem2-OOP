/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sql;

import java.util.Scanner;

/**
 *
 * @author Jassen
 */
public class Sql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       data studentDAO = new data();
    Scanner scanner = new Scanner(System.in);

    System.out.println("1. Insert Student");
    System.out.println("2. View Students");
    System.out.print("Choose an option: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); 

    if (choice == 1) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        studentDAO.SaveData(name, age, course);
    } 
    else if (choice == 2) {
        studentDAO.PrintData();
    } 
    else {
        System.out.println("Invalid choice.");
    }

    scanner.close();
    }
    }
    

