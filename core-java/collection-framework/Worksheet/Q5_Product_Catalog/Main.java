package Worksheet.Q5_Product_Catalog;

import java.util.*;

/*
Problem 5: Product Catalog System (TreeMap, Comparator)
Create a Product class with id, name, price, rating, and stock.
•	Store products in a TreeMap<Integer, Product> keyed by id.
•	Sort and print products by descending rating, and then by name.
 */

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, Product> productMap = new TreeMap<>();
        productMap.put(101, new Product(101, "Laptop", 55000.0, 4.5, 10));
        productMap.put(102, new Product(102, "Smartphone", 30000.0, 4.2, 25));
        productMap.put(103, new Product(103, "Tablet", 20000.0, 4.0, 15));

        List<Product> sortedProducts = new ArrayList<>(productMap.values());
        sortedProducts.sort(
                Comparator.comparingDouble(Product::getRating).reversed()
                        .thenComparing(Product::getName));

        System.out.println("\nSorted Product Catalog:");
        sortedProducts.forEach(System.out::println);
    }
}
