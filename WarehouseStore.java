package com.inventory.lab1;

import java.util.*;
import java.util.stream.Collectors;

public class WarehouseStore<T extends Product> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(String id) {
        return items.removeIf(p -> p.getId().equals(id));
    }

    public List<T> findByCategory(String cat) {
        return items.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(cat))
                .collect(Collectors.toList());
    }

    public List<T> getAll() {
        return items;
    }
}
