package inv;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import books.Book;


public class Inventory {

    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) { // will be used by Admin.java
        if (book == null || books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Invalid book or already exists in inventory");
        }
        books.put(book.getIsbn(), book);
    }

    public Book removeBook(String isbn) {
        if (isbn == null || !books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book not found in inventory");
        }
        return books.remove(isbn);
    }

    public Book removeOutdatedBook(int olderThanYears, int currentYear) {
        for (Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator(); it.hasNext();) {
            Book book = it.next().getValue();
            int num_of_years = currentYear - book.getYear();
            if (num_of_years > olderThanYears) {
                it.remove();
                System.out.println("Removed outdated book - " + book.getTitle());
                return book;
            }
        }
        System.out.println("No outdated books found.");
        return null;
    }

    public double buyBook(String isbn, int quantity, String email, String address) { // will be used by Customer.java
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN cannot be null");
        }
        if (!books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found in inventory");
        }

        Book book = books.get(isbn);
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " and title '" + book.getTitle() + "' is not available for purchase");
        }

        double totalCost = book.buy(quantity, email, address);
        // System.out.println("Purchased " + quantity + " copies of " + book.getTitle()
        //         + " for a total of $" + totalCost);
        return totalCost;
    }

}
