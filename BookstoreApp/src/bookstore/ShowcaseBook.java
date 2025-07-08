package bookstore;

public class ShowcaseBook extends Book {
    public ShowcaseBook(String ISBN, String title, int BookYear,double price) {
        super(ISBN, title, BookYear, price);
    }

    @Override
    public boolean isForSale() {
        return false;
    }
}

