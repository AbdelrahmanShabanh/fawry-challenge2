package bookstore;

public class EService implements DeliveryService {
    @Override
    public void deliver(Product product, int quantity, Object deliveryInfo) {
        if (product == null || deliveryInfo == null) {
            throw new IllegalArgumentException("Product and delivery info must not be null.");
        }

        if (!(product instanceof EBook) || !(deliveryInfo instanceof CustomerEmail)) {
            throw new IllegalArgumentException("Invalid product or delivery info for EBook delivery.");
        }

        EBook ebook = (EBook) product;
        CustomerEmail emailInfo = (CustomerEmail) deliveryInfo;

        System.out.println("Sending \"" + ebook.getTitle() + "\" to " + emailInfo.getEmail());
    }
}


