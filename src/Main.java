import inv.Inventory;
import books.*;
import people.*;



public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Admin admin = new Admin("admin1", inventory);
        Customer customer = new Customer("customer1", inventory);

        // Adding books to inventory by admin

        admin.addBook(new PaperBook("12345", "Modern Physics", 2020, 50.00, 10));
        admin.addBook(new PaperBook("54321", "Java", 2018, 50.00, 5));
        admin.addBook(new EBook("11111", "Mathematics", 2005, 20.00, "PDF"));
        admin.addBook(new EBook("222222", "Design Patterns", 1994, 15.00, "EPUB"));
        admin.addBook(new ShowcaseBook("33333", "Computer Science", 2022, 100.00));

        // Buying books by customer
        System.out.println();
        System.out.println("Buying books (Normal Test Cases):");
        System.out.println("--------------------------------------------------");

        customer.buyBook("12345", 2, "test1@example.com", "123 Test St"); // PaperBook
        customer.buyBook("11111", 1, "test2@example.com", "456 Test Ave"); // EBook
        customer.buyBook("33333", 1, "test3@example.com", "789 Test Blvd"); // ShowcaseBook

        // testing outdated book removal

        inventory.removeOutdatedBook(20, 2025); // Remove books older than 20 years

        // Attempting to buy a book older than 20 years

        System.out.println();
        System.out.println("Attempting to buy an outdated book:");
        System.out.println("--------------------------------------------------");
        customer.buyBook("222222", 1, "test4@example.com", "101 Test Blvd"); // EBook
        
        // Attempting to buy a book with invalid ISBN
        System.out.println();
        System.out.println("Attempting to buy a book with invalid ISBN:");
        System.out.println("--------------------------------------------------");
        customer.buyBook("99999", 1, "test5@example.com", "102 Test Blvd");


        // Attempting to buy a book with insufficient stock
        System.out.println();
        System.out.println("Attempting to buy a book with insufficient stock:");
        System.out.println("--------------------------------------------------");
        customer.buyBook("12345", 100, "test6@example.com", "103 Test Blvd");

        // Attempting to buy Ebook with quantity greater than 1
        System.out.println();
        System.out.println("Attempting to buy an Ebook with quantity greater than 1:");
        System.out.println("--------------------------------------------------");
        customer.buyBook("11111", 2, "test7@example.com", "104 Test Blvd"); // EBook


        // Removing books by admin
        admin.addBook(new PaperBook("44444", "Quantum Mechanics", 2023, 60.00, 15));
        admin.removeBook("44444"); // Attempting to remove a book with null ISBN
        System.out.println();
        System.out.println("Attempting to buy a removed book:");
        System.out.println("--------------------------------------------------");
        customer.buyBook("44444", 1, "test8@example.com", "105 Test Blvd");
    }
    
}
