package bookstore;

public class PaperBookPur extends PurHandler {
    private ShippingService shipping;

    public PaperBookPur(ShippingService shipping) {
        this.shipping = shipping;
    }

    @Override
    public double handlePurchase(Product product, int quantity, Object customerInfo) {
        if (product == null) {
            throw new IllegalArgumentException("Product is not found");
        }

        if (!(product instanceof PaperBook)) {
            throw new IllegalArgumentException("Must be a PaperBook product.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(" must be greater than zero.");
        }

        PaperBook book = (PaperBook) product;

        if (!book.isForSale()) {
            throw new IllegalStateException(book.getTitle() +" is not available for sale");
        }

        book.decreaseStock(quantity);
        double totalPrice = book.getPrice() * quantity;
        shipping.deliver(book, quantity, customerInfo);
        return totalPrice;
    }
}


