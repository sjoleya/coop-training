package Worksheet.Q14_Restaurant_Order_System;

import java.util.Objects;

public class Order {
    private static int idCounter = 1;
    private final int id;
    private final String description;

    public Order(String description) {
        this.id = idCounter++;
        this.description = description;
    }

    public String toString() {
        return "Order #" + id + ": " + description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
