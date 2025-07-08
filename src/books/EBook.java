package books;

public class EBook extends Book {

    private String fileType;

    public EBook(String isbn, String title, int year, double price, String fileType) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }


    @Override
    public boolean isAvailable() {
        return true; // Ebooks are always available (no stock)
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity != 1) {
            throw new IllegalArgumentException("Quantity must be exactly one for EBooks");
        }
        System.out.println("Sending " + fileType + " EBook to " + email);
        return price;
    }

    @Override
    public String getType() {
        return "EBook";
    }

}
