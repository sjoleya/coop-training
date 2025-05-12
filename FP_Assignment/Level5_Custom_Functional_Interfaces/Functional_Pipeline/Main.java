package FP_Assignment.Level5_Custom_Functional_Interfaces.Functional_Pipeline;

/*
Implement a function pipeline to process orders
(e.g., filter by status, sort by amount, map to customer name).
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, "Alice", 250.0, OrderStatus.DELIVERED),
                new Order(2, "Bob", 150.0, OrderStatus.PENDING),
                new Order(3, "Charlie", 300.0, OrderStatus.DELIVERED),
                new Order(4, "Dana", 200.0, OrderStatus.CANCELLED),
                new Order(5, "Eve", 180.0, OrderStatus.DELIVERED)
        );
        List<String> customerNames = orders.stream()
                .filter(order -> OrderStatus.DELIVERED.equals(order.getStatus()))
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .map(Order::getCustomerName)
                .toList();

        System.out.println("Delivered orders sorted by amount (customer names):");
        customerNames.forEach(System.out::println);
    }
}
