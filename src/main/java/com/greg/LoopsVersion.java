package com.greg;

import java.util.ArrayList;
import java.util.List;


public class LoopsVersion extends NameList
{


    public LoopsVersion(List<String> nameData)
    {
        super(nameData.isEmpty() ? new ArrayList<>(): nameData);
        countNames();
    }


    private void countNames()
    {

        for (String name : NAMES)
        {
            nameCounts.put(name, nameCounts.getOrDefault(name, 0L) + 1);
        }
    }

    @Override
    public void display()
    {
        if(numNames == 0)
        {
            System.out.println("NO NAMES TO DISPLAY"); // prevent errors fr
            return; // l8r g8r
        }

        System.out.printf("%-20s %-10s\n", "Name", "Count");
        System.out.println("--------------------------");
        nameCounts.forEach((name, count) -> System.out.printf("%-20s => %-10d\n", name, count));

        System.out.println("I have a total of " + (numNames) + " in this List");

    }



}
