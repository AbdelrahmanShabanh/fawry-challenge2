package bookstore;

import java.util.*;

public class LibrarySystem {
    private Map<String, Product> inventory = new HashMap<>();

    public void addBook(Product book) {
        inventory.put(book.getId(), book);
        System.out.println(book.getTitle() + " was added!");

        System.out.println("\nOur Books:");
        int index = 1;
        for (Product b : inventory.values()) {
            System.out.println(index + ". " + b.getTitle());
            index++;
        }
    }


    public Product getBook(String ISBN) {
        return inventory.get(ISBN);
    }


    public double purchaseBook(String ISBN, int quantity, Object info) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        Product book = getBook(ISBN);
        if (book == null) {
            throw new IllegalArgumentException("Error not found");
        }

        if (!book.isForSale()) {
            throw new IllegalStateException( book.getTitle()+ " is not for sale: ");
        }

        PurHandler handler = PurHandlerFactory.createHandler(book);
        return handler.handlePurchase(book, quantity, info);
    }


    public List<Product> DeleteOutDated(int OutDatedYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Product> removed = new ArrayList<>();

        Iterator<Map.Entry<String, Product>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Product> entry = iterator.next();
            Product book = entry.getValue();

            if (currentYear - book.getYear() > OutDatedYears) {
                removed.add(book);
                iterator.remove();
            }
        }

        return removed;
    }


    public int getInventoryCount() {
        return inventory.size();
    }
}

