package bookstore;

public interface Product {
    String getId();
    String getTitle();
    int getYear();
    double getPrice();
    boolean isForSale();
}

