/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarytest;

/**
 *
 * @author Jassen
 */
public class LibraryTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Library library1 = new Library();
        Library library2 = new Library();

               Book book1 = new Book("1984", "George Orwell", 5);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 3);
        library1.addBook(book1);
        library1.addBook(book2);

       
        System.out.println("Before update:");
        library1.displayLibrary();

      
        library1.updateBookTitle(book1, "Nineteen Eighty-Four");
        library1.updateBookCopies(book2, 10);

        
        int originalNumber = 123;
        System.out.println("\nOriginal number before method call: " + originalNumber);
        library1.attemptPrimitiveChange(originalNumber);
        System.out.println("Original number after method call: " + originalNumber);

       
        library1.transferBook(library2, book2);

       
        System.out.println("\nLibrary 1 after transfer:");
        library1.displayLibrary();

        System.out.println("\nLibrary 2 after receiving book:");
        library2.displayLibrary();

        
        System.out.println("\nCloning book1 and modifying the clone...");
        Book clonedBook = book1.clone();
        clonedBook.setTitle("Cloned - " + clonedBook.getTitle());
        clonedBook.updateCopies(20);

        
        System.out.println("Cloned Book Details:");
        clonedBook.displayInfo();

      
        System.out.println("\nOriginal Book Details After Cloning:");
        book1.displayInfo();
    }
    
}
