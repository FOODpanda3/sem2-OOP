/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarytest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jassen
 */
public class Library {
  private List<Book> books;

    
    public Library() {
        books = new ArrayList<>();
    }

   
    public void addBook(Book book) {
        books.add(book);
    }

   
    public void updateBookTitle(Book book, String newTitle) {
        System.out.println("Updating book title from \"" + book.getTitle() + "\" to \"" + newTitle + "\".");
        book.setTitle(newTitle);
    }

    
    public void updateBookCopies(Book book, int newCopies) {
        book.updateCopies(newCopies);
    }

   
    public void attemptPrimitiveChange(int number) {
        System.out.println("Inside method before change: " + number);
        number = 999;
        System.out.println("Inside method after change: " + number);
    }

   
    public void transferBook(Library targetLibrary, Book book) {
        if (books.contains(book)) {
            books.remove(book);
            targetLibrary.addBook(book);
            System.out.println("Transferred \"" + book.getTitle() + "\" to another library.");
        } else {
            System.out.println("Book not found in this library!");
        }
    }

   
    public void displayLibrary() {
        System.out.println("Library Inventory:");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                book.displayInfo();
            }
        }
    }
}
