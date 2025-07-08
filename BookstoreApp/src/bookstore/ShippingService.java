package bookstore;

public class ShippingService implements DeliveryService {
    @Override
    public void deliver(Product product, int quantity, Object deliveryInfo) {
        if (!(deliveryInfo instanceof AddressInfo)) {
            throw new IllegalArgumentException("Error in delivery info");
        }
        AddressInfo info = (AddressInfo) deliveryInfo;
        System.out.println("Shipping " + quantity + " book of \"" + product.getTitle() + "\" to " + info.getAddress());
    }
}
