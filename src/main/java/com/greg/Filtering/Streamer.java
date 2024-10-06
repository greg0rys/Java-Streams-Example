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
    private long filterTime = 0;
    private long printTime = 0;
    private long start, end;
    public Streamer() { }

    public void matchOrders(List<Order> o, List<User> u)
    {
        // keep the trackers clear each call.
        start = 0;
        end = 0;

        start = currentTime();
        Map<User, List<Order>> orderedMap = u.stream().collect(Collectors.toMap(
                user -> user,
                user -> o.stream().filter(order -> order.getUserID() == user.getUserID()).collect(Collectors.toList())
        ));
        end = currentTime();
        filterTime = getTimeDiff(end, start);


        start = currentTime();
        orderedMap.forEach((user, userOrders) -> {
            if(userOrders.isEmpty()) return; // if the user doesn't have any orders skip them.

            System.out.println(" User: " + user.getName() + " has the orders");
            userOrders.forEach(order -> System.out.println(" \tOrder: { Order ID: " + order.getOrderID() + " }"));
            System.out.println();
        });
        end = currentTime();
        printTime = getTimeDiff(end, start);

        System.out.println();
        System.out.println("Filtering Users & Orders => " + filterTime + " milliseconds\n\tNumber of Filtered Items => " + (o.size() + u.size()));
        System.out.println("Printing Filtered Map => " + printTime + " milliseconds");

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

        System.out.println("\nSTATS => { " + P.size() + " Products took " + filterTime + " milliseconds to process }");
    }



    public long currentTime() { return System.currentTimeMillis(); }
    public long getTimeDiff(long end, long start) { return end - start; }

}
