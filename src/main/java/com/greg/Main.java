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
