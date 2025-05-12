package FP_Assignment.Level7_Custom_Types_And_Nested_Streams.HighestTotalPriceOrder;

import java.util.Arrays;
import java.util.List;

/*
 * Find the order with the highest total item price.
 */

public class Main {

    public static void main(String[] args) {
        Order order1 = new Order(Arrays.asList(new Item("Shirt", 20.0), new Item("Pants", 30.0)));
        Order order2 = new Order(Arrays.asList(new Item("Shoes", 50.0), new Item("Hat", 15.0)));
        List<Order> orders = Arrays.asList(order1, order2);
        Order highestPriceOrder = orders.stream()
                .max((o1, o2) -> Double.compare(o1.getTotalPrice(), o2.getTotalPrice()))
                .orElse(null);
        if (highestPriceOrder == null) {
            System.out.println("No Orders Available!");
        } else {
            System.out.println("Order with highest total price: " + highestPriceOrder);
        }
    }
}
