package FP_Assignment.Level7_Custom_Types_And_Nested_Streams.HighestTotalPriceOrder;

import java.util.List;

class Order {
    private List<Item> items;

    public Order(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
