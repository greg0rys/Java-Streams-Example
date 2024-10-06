package com.greg.Filtering;

import com.greg.Model.Order;
import com.greg.Model.Product;
import com.greg.Model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class Streamer
{
    private static final int MAX_OUTPUT = 25;
    private long filterTime = 0;
    private long printTime = 0;
    private long start, end;
    public Streamer() { }

    public void matchOrders(List<Order> o, List<User> u)
    {
        // keep the trackers clear each call.
        AtomicInteger outputCounter = new AtomicInteger(0);

        Map<User, List<Order>> orderedMap = u.stream().collect(Collectors.toMap(
                user -> user,
                user -> o.stream().filter(order -> order.getUserID() == user.getUserID()).collect(Collectors.toList())
        ));

        orderedMap.forEach((user, userOrders) -> processAndPrintUserOrders(user, userOrders, outputCounter));

    }

    private void processAndPrintUserOrders(User user, List<Order> userOrders, AtomicInteger outputCounter) {
        if(userOrders.isEmpty() || outputCounter.get() >= MAX_OUTPUT) {
            return;
        }

        outputCounter.getAndIncrement();
        printUserAndOrders(user, userOrders);
    }

    private void printUserAndOrders(User user, List<Order> userOrders) {
        StringBuilder output = new StringBuilder(" User: ")
                .append(user.getName())
                .append(" has the orders\n");

        userOrders.forEach(order -> output.append("\tOrder: { Order ID: ")
                .append(order.getOrderID())
                .append(" }\n"));

        System.out.println(output);
    }

    public void orderProducts(List<Product> P)
    {
        AtomicInteger count = new AtomicInteger(0);
        start = currentTime();
        List<Product> sorted = P.stream().distinct().toList();
        end = currentTime();
        filterTime = getTimeDiff(end, start);


        System.out.println("\nOnly displaying [ 25/" + sorted.size()
                + " ] for shorter output.");

        sorted.forEach(product -> {

            count.getAndIncrement(); // be thread safe :) for s

            if(count.get() >= 25)
                return;

            System.out.println(
                    "Product { ID = " + product.getProductID() +
                    " NAME = " + product.getName() + " }"
            );



        });

//        System.out.println("\nSTATS => { " + P.size() + " Products took " + filterTime + " milliseconds to process }");
    }



    public long currentTime() { return System.currentTimeMillis(); }
    public long getTimeDiff(long end, long start) { return end - start; }

}
