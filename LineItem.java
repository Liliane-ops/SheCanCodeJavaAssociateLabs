package com.ecommerce.analytics;

public class LineItem {

    private String productId;
    private String category;
    private double price;
    private int quantity;

    public LineItem(String productId, String category, double price, int quantity) {
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}