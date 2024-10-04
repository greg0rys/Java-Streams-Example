package com.greg;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final List<String> NAMES = new ArrayList<>();
    private static final String CSV_PATH = "C:\\Users\\GregShenefelt\\Documents\\Streams_Example\\src\\main\\java\\com\\greg\\dog_and_cat_names_actual.csv";
    public static void main(String[] args) throws Exception {

        parseNames();

        NameList streamsVersion = new StreamVersion(NAMES);
        NameList loopsVersion = new LoopsVersion(NAMES);

        streamsVersion.display();
        System.out.println();
        loopsVersion.display();


//        List<String> namesF = names.stream()
//                .filter(name -> name.startsWith("L"))
//                .map(String::toUpperCase)
//                .distinct()
//                .toList();
//
//        System.out.println("There are " + namesF.size() + " names that start with the letter L");
//        namesF.forEach(System.out::println);

        // Count occurrences of each name
//        Map<String, Long> nameCounts = NAMES.stream()
//                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
//
//        // Print the counts in a table format
//        System.out.printf("%-20s %-10s\n", "Name", "Count");
//        System.out.println("-------------------------");
//        nameCounts.forEach((name, count) -> System.out.printf("%-20s => %-10d\n", name, count));
    }

    public static  void parseNames() throws Exception
    {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_PATH)))
        {
            String[] line;

            while ((line = reader.readNext()) != null)
                NAMES.add(line[0]);
        }
    }
}
