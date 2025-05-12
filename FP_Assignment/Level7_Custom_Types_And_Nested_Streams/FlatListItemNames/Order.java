package FP_Assignment.Level7_Custom_Types_And_Nested_Streams.FlatListItemNames;

import java.util.List;

class Order {
    private List<Item> items;

    public Order(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
