package books;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, int year, double price) {
        super(isbn, title, year, price); 
    }

    @Override
    public boolean isAvailable() {
        return false; // Still demo 
    }

    @Override
    public double buy(int quantity, String email, String address) {
        throw new UnsupportedOperationException("ShowcaseBook cannot be purchased yet");
    }
    
    @Override
    public String getType() {
        return "ShowcaseBook";
    }
}
