package bookstore;

public class EBook extends Book {
    private String fileType;

    public EBook(String ISBN, String title, double price, int publishYear, String fileType) {
        super(ISBN, title, publishYear, price);
        this.fileType = fileType != null ? fileType : "Unknown";
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    public String getFileType() {
        return fileType;
    }
}

