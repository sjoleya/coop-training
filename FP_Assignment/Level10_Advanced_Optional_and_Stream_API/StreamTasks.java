package FP_Assignment.Level10_Advanced_Optional_and_Stream_API;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StreamTasks {

    // Safely get the third element of a list
    public <T> Optional<T> getThirdElement(List<T> list) {
        return list.stream()
                .skip(2)
                .findFirst();
    }

    // Validate URLs using a Predicate and return only valid ones
    public List<String> validateUrls(List<String> urls, Predicate<String> validator) {
        return urls.stream()
                .filter(validator)
                .toList();
    }

    // Chain operations on a list of Orders: filter by date range, map to total
    // amount, sum all totals
    public double calculateTotalOrderAmount(List<Order> orders, java.time.LocalDate startDate,
            java.time.LocalDate endDate) {
        return orders.stream()
                .filter(order -> !order.getOrderDate().isBefore(startDate) && !order.getOrderDate().isAfter(endDate))
                .mapToDouble(Order::getTotalAmount)
                .sum();
    }
}