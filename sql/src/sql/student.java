/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

/**
 *
 * @author Jassen
 */
public class student {
     private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String contact;
    private String address;
    private String email;

    public student(int id, String firstName, String middleName, String lastName, String contact, String address, String email) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
        this.email = email;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getContact() { return contact; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
}

