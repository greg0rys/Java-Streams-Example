package com.greg;

import com.greg.Filtering.Streamer;
import com.greg.Model.Order;
import com.greg.Model.Product;
import com.greg.Model.User;
import com.greg.Sorting.LoopsVersion;

import java.util.List;


public class Main {
    private static final List<String> NAMES = Parser.parseNames();
    private static final Streamer S = new Streamer();
    private static final LoopsVersion LV = new LoopsVersion(NAMES);
    private static final List<Product> PRODUCT = Parser.parseProdcuts();
    private static final List<User> USERS = Parser.parseUsers();
    private static final List<Order> ORDERS = Parser.parseOrders();


    public static void main(String[] args)
    {

        S.matchOrders(ORDERS, USERS); // use a stream to filter
        LV.matchOrders(ORDERS, USERS); // use a loop to filter

    }


}


