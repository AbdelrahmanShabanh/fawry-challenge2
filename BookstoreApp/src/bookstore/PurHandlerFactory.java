package bookstore;

public class PurHandlerFactory {

    public static PurHandler createHandler(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product is empty!.");
        }

        if (product instanceof PaperBook) {
            return new PaperBookPur(new ShippingService());
        } else if (product instanceof EBook) {
            return new EBookPur(new EService());
        } else {
            throw new IllegalArgumentException("No handler available ");
        }
    }
}


