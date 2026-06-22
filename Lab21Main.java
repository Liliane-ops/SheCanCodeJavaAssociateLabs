package com.ecommerce.analytics;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lab21Main {

    public static void main(String[] args) {

        List<Order> orders = createOrders();


        List<LineItem> allItems =
                orders.stream()
                        .flatMap(order ->
                                order.getLineItems().stream())
                        .toList();

        System.out.println("All Items = " + allItems.size());


        double totalRevenue =
                orders.stream()
                        .flatMap(order ->
                                order.getLineItems().stream())
                        .filter(item ->
                                item.getQuantity() > 5)
                        .map(item ->
                                item.getPrice() * item.getQuantity())
                        .reduce(0.0, Double::sum);

        System.out.println("Revenue Quantity > 5 = " + totalRevenue);

        System.out.println("\nTop Products:");
        topNProductsByRevenue(orders, 3)
                .forEach(System.out::println);

        Map<String, Long> categoryCount =
                allItems.stream()
                        .collect(Collectors.groupingBy(
                                LineItem::getCategory,
                                Collectors.counting()
                        ));

        System.out.println("\nCategory Count");
        System.out.println(categoryCount);


        Map<Boolean, List<Order>> partitioned =
                orders.stream()
                        .collect(Collectors.partitioningBy(
                                Order::isDelivered
                        ));

        System.out.println("\nDelivered/Pending");
        System.out.println(partitioned);

        Map<String, Double> averagePrice =
                allItems.stream()
                        .collect(Collectors.toMap(
                                LineItem::getProductId,
                                LineItem::getPrice,
                                (a, b) -> (a + b) / 2
                        ));

        System.out.println("\nAverage Price Map");
        System.out.println(averagePrice);


        Collector<LineItem, RevenueReport, RevenueReport> collector =
                Collector.of(
                        RevenueReport::new,

                        (report, item) -> {
                            double revenue =
                                    item.getPrice() *
                                            item.getQuantity();

                            report.addRevenue(revenue);
                        },

                        (r1, r2) -> {
                            r1.combine(r2);
                            return r1;
                        }
                );

        RevenueReport report =
                allItems.stream()
                        .collect(collector);

        System.out.println("\nRevenue Report");
        System.out.println(report);


        List<Map.Entry<String, Double>> sequential =
                topNProductsByRevenue(orders, 3);

        List<Map.Entry<String, Double>> parallel =
                topNProductsByRevenueParallel(orders, 3);

        System.out.println("\nSequential");
        System.out.println(sequential);

        System.out.println("\nParallel");
        System.out.println(parallel);

        System.out.println(
                sequential.equals(parallel)
        );
    }


    public static List<Map.Entry<String, Double>>
    topNProductsByRevenue(List<Order> orders, int n) {

        return orders.stream()
                .flatMap(order ->
                        order.getLineItems().stream())
                .collect(Collectors.groupingBy(
                        LineItem::getProductId,
                        Collectors.summingDouble(
                                item ->
                                        item.getPrice()
                                                * item.getQuantity()
                        )
                ))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Double>
                                        comparingByValue()
                                .reversed()
                )
                .limit(n)
                .toList();
    }


    public static List<Map.Entry<String, Double>>
    topNProductsByRevenueParallel(List<Order> orders, int n) {

        return orders.parallelStream()
                .flatMap(order ->
                        order.getLineItems().stream())
                .collect(Collectors.groupingBy(
                        LineItem::getProductId,
                        Collectors.summingDouble(
                                item ->
                                        item.getPrice()
                                                * item.getQuantity()
                        )
                ))
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Double>
                                        comparingByValue()
                                .reversed()
                )
                .limit(n)
                .toList();
    }

    private static List<Order> createOrders() {

        Order o1 = new Order(
                "O1",
                true,
                List.of(
                        new LineItem("P1", "Electronics", 1000, 2),
                        new LineItem("P2", "Electronics", 20, 10)
                )
        );

        Order o2 = new Order(
                "O2",
                false,
                List.of(
                        new LineItem("P1", "Electronics", 1000, 1),
                        new LineItem("P3", "Accessories", 50, 7)
                )
        );

        Order o3 = new Order(
                "O3",
                true,
                List.of(
                        new LineItem("P4", "Furniture", 200, 8),
                        new LineItem("P2", "Electronics", 20, 3)
                )
        );

        return List.of(o1, o2, o3);
    }
}