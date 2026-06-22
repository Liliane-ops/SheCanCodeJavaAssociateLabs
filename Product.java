package com.inventory.lab1;
public class Product {
    private String id;
    private String name;
    private String category;
    private Double price;

    public Product(String id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | " + price;
    }
}

