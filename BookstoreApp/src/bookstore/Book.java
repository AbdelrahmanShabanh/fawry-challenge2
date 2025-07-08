package bookstore;

public abstract class Book implements Product {
    protected String ISBN;
    protected String title;
    protected int BookYear;
    protected double price;


    public Book(String ISBN, String title,int BookYear, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.BookYear = BookYear;
        this.price = price;

    }

    @Override
    public String getId() { return ISBN; }

    @Override
    public String getTitle() { return title; }

    @Override
    public int getYear() { return BookYear; }

    @Override
    public double getPrice() { return price; }

    @Override
    public abstract boolean isForSale();
}

