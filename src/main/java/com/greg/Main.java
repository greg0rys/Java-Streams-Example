package com.greg;

import com.greg.Filtering.Streamer;
import com.greg.Model.Order;
import com.greg.Model.Product;
import com.greg.Model.User;
import com.greg.Sorting.LoopsVersion;
import com.greg.Sorting.StreamVersion;

import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final List<String> NAMES = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        NAMES.addAll(Parser.parseNames());

        StreamVersion streamsVersion = new StreamVersion(NAMES);
        LoopsVersion loopsVersion = new LoopsVersion(NAMES);
        List<Order> orders = Parser.parseOrders();
        List<Product> products = Parser.parseProdcuts();
        List<User> users = Parser.parseUsers();
//
//        System.out.println();
//
//        streamsVersion.printStats(
//                loopsVersion.getLoopsTime(),
//                streamsVersion.getStreamsTime()
//        );
//
//
//        for(User user : users)
//            System.out.println(user);
//
//        System.out.println();
//
//        for(Order o : orders)
//            System.out.println(o);
//
//        System.out.println();
//
//        for(Product p : products)
//            System.out.println(p);
//
//        for(int i = 0; i <=1; i++)
//            System.out.println();
//
        new Streamer().matchOrders(orders, users);


    }

//    public static  void parseNames() throws Exception
//    {
//        try (CSVReader reader = new CSVReader(new FileReader(CSV_PATH)))
//        {
//            String[] line;
//
//            while ((line = reader.readNext()) != null)
//                NAMES.add(line[0]);
//        }
//    }
}
