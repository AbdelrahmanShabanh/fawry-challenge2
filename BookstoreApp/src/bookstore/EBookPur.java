package bookstore;

public class EBookPur extends PurHandler {
    private EService eService;

    public EBookPur(EService eService) {
        this.eService = eService;
    }

    @Override
    public double handlePurchase(Product product, int quantity, Object customerInfo) {
        if (product == null || customerInfo == null) {
            throw new IllegalArgumentException("Product and customer information must not be null.");
        }

        if (!(product instanceof EBook)) {
            throw new IllegalArgumentException("Invalid product type. Expected an EBook.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be at least 1.");
        }

        EBook book = (EBook) product;

        if (!book.isForSale()) {
            throw new IllegalStateException("The book '" + book.getTitle() + "' is not currently available for sale.");
        }


        double totalPrice = book.getPrice() * quantity;
        eService.deliver(book, quantity, customerInfo);

        return totalPrice;
    }
}

