package people;

import inv.Inventory;

public class Customer {
    private Inventory inventory;
    private String username;

    public Customer(String username, Inventory inventory) {
        this.username = username;
        this.inventory = inventory;
    }

    public String getUsername() {
        return username;
    }

    public void buyBook(String isbn, int quantity, String email, String address) {
        try {
            inventory.buyBook(isbn, quantity, email, address);
        } catch (IllegalArgumentException e) {
            System.out.println("Error purchasing book: " + e.getMessage());
        }
    }

}
