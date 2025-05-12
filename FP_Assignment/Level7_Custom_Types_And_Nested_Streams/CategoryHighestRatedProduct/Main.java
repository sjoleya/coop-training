package FP_Assignment.Level7_Custom_Types_And_Nested_Streams.CategoryHighestRatedProduct;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given a list of products with category and rating, 
 * return a map of category → highest-rated product name.
 */

public class Main {

    public static void main(String[] args) {
        // Sample data
        Product product1 = new Product("Laptop", "Electronics", 4.5);
        Product product2 = new Product("Shirt", "Clothing", 4.0);
        Product product3 = new Product("Headphones", "Electronics", 4.8);
        Product product4 = new Product("Pants", "Clothing", 4.2);
        List<Product> products = Arrays.asList(product1, product2, product3, product4);

        Map<String, String> categoryToHighestRatedProduct = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy((p1, p2) -> Double.compare(p1.getRating(), p2.getRating())),
                                product -> product.map(Product::getName).orElse(null))));

        System.out.println(categoryToHighestRatedProduct);
    }

}
