package com.inventory.lab1;

import java.util.*;

public class ComparatorDemo {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("P1", "Phone", "Electronics", 500.0));
        products.add(new Product("P2", "TV", "Electronics", 900.0));
        products.add(new Product("P3", "Book", "Education", null)); // edge case
        products.add(new Product("P4", "Laptop", "Electronics", 900.0));
        products.add(new Product("P5", "Pen", "Education", 2.0));

        Comparator<Product> comparator =
                Comparator.comparing(Product::getCategory)
                        .thenComparing(
                                p -> p.getPrice() == null ? 0.0 : -p.getPrice(),
                                Comparator.naturalOrder()
                        );

        products.sort(comparator);

        System.out.println("Sorted Products:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}