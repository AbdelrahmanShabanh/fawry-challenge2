package bookstore;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String ISBN, String title, int BookYear,double price,int stock) {
        super(ISBN, title,BookYear ,price);
        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return stock > 0;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException(title + "is low on stock");
        }
        stock -= quantity;
    }

    public void increaseStock(int quantity) {
        stock += quantity;
    }
}

