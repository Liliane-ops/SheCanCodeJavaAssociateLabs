package com.stockexchange.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Lab13Main {

    public static void main(String[] args)
            throws InterruptedException {

        double totalThroughput = 0;

        for (int run = 1; run <= 5; run++) {

            OrderBook orderBook = new OrderBook();

            List<Thread> threads = new ArrayList<>();

            long startTime = System.currentTimeMillis();

            // 10 BUYERS
            for (int i = 0; i < 10; i++) {

                Thread t =
                        new Thread(
                        );

                threads.add(t);
                t.start();
            }

            // 10 SELLERS
            for (int i = 0; i < 10; i++) {

                Thread t =
                        new Thread(
                                new Consumer(orderBook, 100)
                        );

                threads.add(t);
                t.start();
            }

            for (Thread t : threads) {
                t.join();
            }

            int poolSize =
                    Runtime.getRuntime()
                            .availableProcessors();

            ExecutorService executor =
                    Executors.newFixedThreadPool(poolSize);

            List<Future<MatchResult>> futures =
                    new ArrayList<>();

            for (int i = 0; i < poolSize; i++) {

                futures.add(
                        executor.submit(
                                new OrderMatchingTask(orderBook)
                        )
                );
            }

            int totalMatched = 0;

            for (Future<MatchResult> future : futures) {

                try {

                    totalMatched +=
                            future.get()
                                    .getMatchedOrders();

                } catch (ExecutionException e) {

                    System.out.println(
                            "Matching error: "
                                    + e.getCause()
                    );
                }
            }

            executor.shutdown();

            long endTime =
                    System.currentTimeMillis();

            double seconds =
                    (endTime - startTime) / 1000.0;

            double throughput =
                    totalMatched / seconds;

            totalThroughput += throughput;

            System.out.println(
                    "\nRun " + run
            );

            System.out.println(
                    "Matched Orders = "
                            + totalMatched
            );

            System.out.println(
                    "Remaining BUY = "
                            + orderBook.getBuySize()
            );

            System.out.println(
                    "Remaining SELL = "
                            + orderBook.getSellSize()
            );

            System.out.println(
                    "Throughput = "
                            + throughput
                            + " orders/sec"
            );
        }

        System.out.println(
                "\nAverage Throughput (5 Runs): "
                        + (totalThroughput / 5)
                        + " orders/sec"
        );
    }
}