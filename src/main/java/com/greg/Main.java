package com.greg;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\GregShenefelt\\Documents\\Streams_Example\\src\\main\\java\\com\\greg\\dog_and_cat_names_actual.csv"; // Update with your CSV file path

        List<String> names = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            // Read each line of the CSV
            while ((line = reader.readNext()) != null) {
                String name = line[0];   // First column: Name
                String age = line[1];    // Second column: Age
                String sound = line[2];  // Third column: Sound

                names.add(name);
                // Print the details
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

//        List<String> namesF = names.stream()
//                .filter(name -> name.startsWith("L"))
//                .map(String::toUpperCase)
//                .distinct()
//                .toList();
//
//        System.out.println("There are " + namesF.size() + " names that start with the letter L");
//        namesF.forEach(System.out::println);

        // Count occurrences of each name
        Map<String, Long> nameCounts = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        // Print the counts in a table format
        System.out.printf("%-20s %-10s\n", "Name", "Count");
        System.out.println("-------------------------");
        nameCounts.forEach((name, count) -> System.out.printf("%-20s => %-10d\n", name, count));
    }
}
