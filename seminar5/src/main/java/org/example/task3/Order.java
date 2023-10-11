package org.example.task3;

public class Order {
    private final double totalAmount;

    public Order(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}