package FP_Assignment.Level10_Advanced_Optional_and_Stream_API;

import java.time.LocalDate;

public class Order {
    private static int idCounter = 0;
    private int id;
    private LocalDate orderDate;
    private double totalAmount;

    public Order(LocalDate orderDate, double totalAmount) {
        this.id = idCounter++;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}