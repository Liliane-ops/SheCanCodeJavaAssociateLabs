package com.stockexchange.concurrent;

public class Order {

    private String id;
    private String type;
    private int quantity;

    public Order(String id, String type, int quantity) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return id + " " + type + " " + quantity;
    }
}