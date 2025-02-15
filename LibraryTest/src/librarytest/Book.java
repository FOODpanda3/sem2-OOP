package librarytest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jassen
 */
public class Book {
     private String title;
    private String author;
    private int copies;

   
    public Book(String title, String author, int copies) {
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

   
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Copies: " + copies);
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
    
   public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
      public void updateCopies(int newCopies) {
        System.out.println("Updating copies for \"" + title + "\" from " + copies + " to " + newCopies + ".");
        this.copies = newCopies;
    }
      
       @Override
    public Book clone() {
        return new Book(this.title, this.author, this.copies);
    }
}
