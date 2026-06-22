package com.ecommerce.analytics;

import java.util.List;

public class Order {

    private String orderId;
    private boolean delivered;
    private List<LineItem> lineItems;

    public Order(String orderId, boolean delivered, List<LineItem> lineItems) {
        this.orderId = orderId;
        this.delivered = delivered;
        this.lineItems = lineItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}