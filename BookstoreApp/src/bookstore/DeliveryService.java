package bookstore;

public interface DeliveryService {
    void deliver(Product product, int quantity, Object deliveryInfo);
}

