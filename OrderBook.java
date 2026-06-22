package com.stockexchange.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

public class OrderBook {

    private final ConcurrentLinkedQueue<Order> buyOrders =
            new ConcurrentLinkedQueue<>();

    private final ConcurrentLinkedQueue<Order> sellOrders =
            new ConcurrentLinkedQueue<>();

    private final ReentrantLock lock =
            new ReentrantLock();

    private int matchedCount = 0;

    public void addOrder(Order order) {

        lock.lock();

        try {

            if ("BUY".equals(order.getType())) {
                buyOrders.add(order);
            } else {
                sellOrders.add(order);
            }

        } finally {
            lock.unlock();
        }
    }

    public MatchResult matchOrders() {

        lock.lock();

        try {

            int matched = 0;

            while (!buyOrders.isEmpty()
                    && !sellOrders.isEmpty()) {

                buyOrders.poll();
                sellOrders.poll();

                matched++;
                matchedCount++;
            }

            return new MatchResult(matched);

        } finally {
            lock.unlock();
        }
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getBuySize() {
        return buyOrders.size();
    }

    public int getSellSize() {
        return sellOrders.size();
    }
}