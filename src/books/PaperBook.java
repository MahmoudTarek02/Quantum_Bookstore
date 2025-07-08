package books;

public class PaperBook extends Book{

    private int stock;

    public PaperBook(String isbn, String title, int year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock available for '" + title + "' (ISBN: " + isbn + ")");
        }
        String copyWord = (quantity == 1) ? "copy" : "copies";
        System.out.println("Shipping " + quantity + " " + copyWord + " of PaperBook '" + title + "' to " + address);
        stock -= quantity;
        return quantity * price;

    }
    @Override
    public String getType() {
        return "PaperBook";
    }
}
