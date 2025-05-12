package FP_Assignment.Level7_Custom_Types_And_Nested_Streams.FlatListItemNames;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * You have a list of Order objects, each with a list of Items. 
 * Return a flat list of all item names.
 */

public class Main {

    public static void main(String[] args) {
        // Sample data
        Order order1 = new Order(Arrays.asList(new Item("Shirt"), new Item("Pants")));
        Order order2 = new Order(Arrays.asList(new Item("Shoes"), new Item("Hat")));
        List<Order> orders = Arrays.asList(order1, order2);
        List<String> itemNames = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(Item::getName)
                .collect(Collectors.toList());
        ;
        System.out.println(itemNames);
    }

}
