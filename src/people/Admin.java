package people;

import inv.Inventory;
import books.Book;

public class Admin {
    private String username;
    private Inventory inventory;

    public Admin(String username, Inventory inventory) {
        this.username = username;
        this.inventory = inventory;
    }

    public String getUsername() {
        return username;
    }

    public void addBook(Book book) {
        inventory.addBook(book);
        // System.out.println("Admin " + username + " added book: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        inventory.removeBook(isbn);
    }

}
