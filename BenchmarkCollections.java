package com.inventory.lab1;

import java.util.*;

public class BenchmarkCollections {

    public static void main(String[] args) {

        List<Product> arrayList = new ArrayList<>();
        List<Product> linkedList = new LinkedList<>();
        Set<Product> hashSet = new HashSet<>();
        Set<Product> treeSet = new TreeSet<>(Comparator.comparing(Product::getId));

        int size = 1000;

        // Generate products
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            products.add(new Product("P" + i, "Item" + i, "Cat" + (i % 10), (double) i));
        }

        // ---- INSERTION BENCHMARK ----
        long start = System.nanoTime();
        arrayList.addAll(products);
        long end = System.nanoTime();
        System.out.println("ArrayList insert: " + (end - start));

        start = System.nanoTime();
        linkedList.addAll(products);
        end = System.nanoTime();
        System.out.println("LinkedList insert: " + (end - start));

        start = System.nanoTime();
        hashSet.addAll(products);
        end = System.nanoTime();
        System.out.println("HashSet insert: " + (end - start));

        start = System.nanoTime();
        treeSet.addAll(products);
        end = System.nanoTime();
        System.out.println("TreeSet insert: " + (end - start));

        // ---- LOOKUP ----
        start = System.nanoTime();
        arrayList.contains(products.get(500));
        end = System.nanoTime();
        System.out.println("ArrayList lookup: " + (end - start));

        start = System.nanoTime();
        hashSet.contains(products.get(500));
        end = System.nanoTime();
        System.out.println("HashSet lookup: " + (end - start));

        // ---- ITERATION ----
        start = System.nanoTime();
        for (Product p : arrayList) {}
        end = System.nanoTime();
        System.out.println("ArrayList iteration: " + (end - start));
    }
}