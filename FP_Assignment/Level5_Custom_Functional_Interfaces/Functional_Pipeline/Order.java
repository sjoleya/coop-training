package FP_Assignment.Level5_Custom_Functional_Interfaces.Functional_Pipeline;

public class Order {
    int id;
    String customerName;
    double amount;
    OrderStatus status;

    public Order(int id, String customerName, double amount, OrderStatus status) {
        this.id = id;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return customerName + " ($" + amount + ") [" + status + "]";
    }
}
