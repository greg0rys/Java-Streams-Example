package com.greg.Sorting;

import com.greg.Model.Order;
import com.greg.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;



public class LoopsVersion extends NameList
{
    private static final int MAX_OUTPUT = 25;

    public LoopsVersion(List<String> nameData)
    {
        super(nameData.isEmpty() ? new ArrayList<>(): nameData);
        countNames();
    }

    public long getLoopsTime() { return loopsRunTime; }

    private void countNames()
    {
        long startTime = System.currentTimeMillis();

        if(NAMES.isEmpty()) return; // no names isn't a vibe.

        for (String name : NAMES)
        {
            nameCounts.put(name, nameCounts.getOrDefault(name, 0L) + 1);
        }

        sortMap();
        long endTime = System.currentTimeMillis();
        loopsRunTime = endTime - startTime;
    }
    @Override
    public void display()
    {
        System.out.println("Using Loops");

        if(numNames == 0)
        {
            System.out.println("NO NAMES TO DISPLAY"); // prevent errors fr
            return; // l8r g8r
        }
        System.out.printf("%-20s %-10s\n", "Name", "Count");
        System.out.println("--------------------------");
        nameCounts.forEach((name, count) -> System.out.printf("%-20s <=> %-10d\n", name, count));
        System.out.println();


    }

    public void matchOrders(List<Order> o, List<User> u) {
        // keep the trackers clear each call.
        AtomicInteger outputCounter = new AtomicInteger(0);

        // Create a map to store users and their corresponding orders
        Map<User, List<Order>> orderedMap = new HashMap<>();

        // Loop through each user
        for (User user : u) {
            List<Order> userOrders = new ArrayList<>();

            // Loop through each order to find matching userID
            for (Order order : o) {
                if (order.getUserID() == user.getUserID()) {
                    userOrders.add(order);
                }
            }

            // Put the user and their orders into the map
            orderedMap.put(user, userOrders);
        }

        // Process and print the orders for each user
        for (Map.Entry<User, List<Order>> entry : orderedMap.entrySet()) {
            User user = entry.getKey();
            List<Order> userOrders = entry.getValue();

            processAndPrintUserOrders(user, userOrders, outputCounter);
        }
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


}
