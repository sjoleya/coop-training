package Worksheet.Q10_Inventory_Management;

/*
Create a `Product` class with `id`, `name`, and `price`. Create an array of products in a `Store` class.
Write methods to:
- Display all products
- Find product with highest price
- Search product by name
 */

import java.util.*;

class Product {
    int id;
    String name;
    double price;

    public double getPrice() {
        return price;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: ₹" + price;
    }
}

class Store {
    private final ArrayList<Product> _products = new ArrayList<>();
    public Store() {
        // Adding a dummy list of products
        _products.add(new Product(1, "Laptop", 1199.99));
        _products.add(new Product(2, "Smartphone", 899.99));
        _products.add(new Product(3, "Tablet", 349.99));
        _products.add(new Product(4, "HeadPhones", 129.99));

    }
    public void displayAllProducts() {
        if (_products.isEmpty()) {
            System.out.println("The store has no products.");
            return;
        }
        System.out.println("--- All Products ---");
        for (Product product : _products) {
            System.out.println(product);
        }
        System.out.println("--------------------");
    }
    public Product getProductWithHighestPrice() {
        if(_products.isEmpty()) {
            return null;
        }
        int index = 0;
        double maxPriceSoFar = _products.get(0).getPrice();
        for(int i = 0; i < _products.size(); i++) {
            double currPrice = _products.get(i).getPrice();
            if(currPrice > maxPriceSoFar) {
                index = i;
                maxPriceSoFar = currPrice;
            }
        }
        return _products.get(index);
    }
    public boolean searchProductByName(String name) {
        for(Product product : _products) {
            if(product.name.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Problem10 {
    public static void main(String[] args) {
        Store myStore = new Store();
        myStore.displayAllProducts();

        System.out.println("\nMost expensive product:");
        Product maxProduct = myStore.getProductWithHighestPrice();
        System.out.println(maxProduct != null ? maxProduct : "No products found.");

        System.out.println("\nSearch for 'Tablet': " + (myStore.searchProductByName("Tablet") ? "Found" : "Not Found"));
        System.out.println("Search for 'Camera': " + (myStore.searchProductByName("Camera") ? "Found" : "Not Found"));
    }
}
