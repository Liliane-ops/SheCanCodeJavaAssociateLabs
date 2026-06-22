package com.inventory.lab1;

public class Testing {
    public static void main(String[] args) {

        WarehouseStore<Product> store = new WarehouseStore<>();

        store.addItem(new Product("P1", "Laptop", "Electronics", 800.0));
        System.out.println("Generics constraint works correctly!");
    }
}