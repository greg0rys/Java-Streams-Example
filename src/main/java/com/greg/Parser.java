package com.greg;

import com.greg.Model.Order;
import com.greg.Model.Product;
import com.greg.Model.User;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Parser
{
    private static final String USERS_CSV_PATH = "C:\\Users\\GregShenefelt\\Documents\\Streams_Example\\src\\main\\java\\com\\greg\\Data\\users.csv";
    private static final String PRODUCTS_CSV_PATH = "C:\\Users\\GregShenefelt\\Documents\\Streams_Example\\src\\main\\java\\com\\greg\\Data\\products.csv";
    private static final String ORDERS_CSV_PATH = "C:\\Users\\GregShenefelt\\Documents\\Streams_Example\\src\\main\\java\\com\\greg\\Data\\orders.csv";
    private static final String NAMES_CSV_PATH = "C:\\Users\\GregShenefelt\\Documents\\Streams_Example\\src\\main\\java\\com\\greg\\Data\\names.csv";


    private static final List<String> NAMES = new ArrayList<>();
    private static final List<User> USERS = new ArrayList<>();
    private static final List<Order> ORDERS = new ArrayList<>();
    private static final List<Product> PRODUCTS = new ArrayList<>();

    private Parser() { }

    /**
     * Parse the names CSV file.
     * @return a list of the CSV's contents
     */
    public static List<String> parseNames()
    {
        try (CSVReader reader = new CSVReader(new FileReader(NAMES_CSV_PATH)))
        {
            String[] line;

            while ((line = reader.readNext()) != null)
                NAMES.add(line[0]);

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }

        return NAMES;
    }


    public static List<User> parseUsers()
    {
        try(CSVReader reader = new CSVReader(new FileReader(USERS_CSV_PATH)))
        {
            String[] line;
            int lineNumber = 0;
            while((line = reader.readNext()) != null)
            {
                lineNumber++;
                // avoid parsing the header row of the CSV file
                if(lineNumber == 1)
                    continue;

                USERS.add(new User(Integer.parseInt(line[0]), Integer.parseInt(line[3]),line[1], line[2]));
            }
        }
        catch (IOException | CsvValidationException e)
        {
            throw new RuntimeException(e);
        }

        return USERS;
    }


    public static List<Order> parseOrders()
    {
        try(CSVReader reader = new CSVReader((new FileReader(ORDERS_CSV_PATH))))
        {
            String[] line;
            int lineNum = 0;

            while((line = reader.readNext()) != null)
            {
                lineNum++;

                if(lineNum == 1)
                    continue;

                ORDERS.add(new Order(
                        Integer.parseInt(line[0]),
                        Integer.parseInt(line[1]),
                        Integer.parseInt(line[2]),
                        Integer.parseInt(line[3])
                ));
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException();
        }

        return ORDERS;
    }

    public static List<Product> parseProdcuts()
    {
        try(CSVReader reader = new CSVReader((new FileReader(PRODUCTS_CSV_PATH))))
        {
            String[] line;
            int lineNum = 0;

            while((line = reader.readNext()) != null)
            {
                lineNum++;

                if(lineNum == 1)
                    continue;

                PRODUCTS.add(new Product(
                        Integer.parseInt(line[0]),
                        Integer.parseInt(line[4]),
                        line[1],
                        line[2]
                ));
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException();
        }

        return PRODUCTS;
    }
}
