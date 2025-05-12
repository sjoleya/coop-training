package FP_Assignment.Level10_Advanced_Optional_and_Stream_API;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/*
 * Safely get the third element of a list using stream().skip(2).findFirst() and return Optional<T>. 
 * Given a list of URLs (strings), use streams to validate them using a Predicate<String> and return only valid ones.
 * Chain operations on a list of Orders: filter by date range, map to total amount, sum all totals.
 */

public class Main {
    public static void main(String[] args) {
        StreamTasks tasks = new StreamTasks();

        // Example for getThirdElement
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> thirdElement = tasks.getThirdElement(numbers);
        System.out.println("Third element: " + thirdElement.orElse(null));

        // Example for validateUrls
        List<String> urls = Arrays.asList("http://example.com", "invalid-url", "https://google.com");
        Predicate<String> urlValidator = url -> url.startsWith("http://") || url.startsWith("https://");
        List<String> validUrls = tasks.validateUrls(urls, urlValidator);
        System.out.println("Valid URLs: " + validUrls);

        // Example for calculateTotalOrderAmount
        List<Order> orders = Arrays.asList(
                new Order(LocalDate.of(2024, 1, 15), 100.0),
                new Order(LocalDate.of(2024, 2, 20), 200.0),
                new Order(LocalDate.of(2024, 3, 10), 150.0));
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 2, 28);
        double totalAmount = tasks.calculateTotalOrderAmount(orders, startDate, endDate);
        System.out.println("Total order amount: " + totalAmount);
    }
}