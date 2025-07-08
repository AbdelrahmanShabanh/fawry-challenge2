package bookstore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibrarySystem store = new LibrarySystem();

        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*       WELCOME TO OUR BOOK STORE!       *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        store.addBook(new PaperBook("12345", "elfel elazra2 ", 2019, 250.99, 7));
        store.addBook(new EBook("1212121", "A Tale of Two Cities ", 19.99, 2022, "PDF"));
        store.addBook(new ShowcaseBook("5555555", "HEBTA ", 0, 2025));
        store.addBook(new PaperBook("12345", "Oliver Twist ", 2005, 449.99, 7));
        store.addBook(new PaperBook("13456", "Great Expectations ", 2023, 749.99, 5));
        store.addBook(new EBook("46789", "Hard Times ", 13.50, 2024, "EPUB"));
        store.addBook(new ShowcaseBook("66666", "ELAYAM ", 0, 2025));


        System.out.println("We have " + store.getInventoryCount()+" books IN OUR STORE");

        try {
            double total = store.purchaseBook("12345", 4, new AddressInfo("portsaid"));
            System.out.println("Your Book purchase successfully and the price is: " + total+" EGP");
        } catch (Exception e) {
            System.out.println("error in purchase");
        }

        try {
            double total = store.purchaseBook("1212121", 1, new CustomerEmail("bodysh2019@gmail.com"));
            System.out.println("EBook was sent successfully and the price is: " + total+ " EGP");
        } catch (Exception e) {
            System.out.println("error in purchase");
        }

        try {
            store.purchaseBook("5555555", 1, new AddressInfo("portsaid"));
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        List<Product> outdated = store.DeleteOutDated(15);
        System.out.println("we remove " + outdated.size() + " outdated book");
        System.out.println("Now we have " + store.getInventoryCount() + " books");
    }
}
