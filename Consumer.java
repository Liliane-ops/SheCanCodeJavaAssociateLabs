package com.stockexchange.concurrent;

public class Consumer implements Runnable {

    private final OrderBook orderBook;
    private final int count;

    public Consumer(OrderBook orderBook, int count) {
        this.orderBook = orderBook;
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 0; i < count; i++) {

            orderBook.addOrder(
                    new Order(
                            "S" + Thread.currentThread().getId() + "-" + i,
                            "SELL",
                            100
                    )
            );
        }
    }
}