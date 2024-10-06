package com.greg.Sorting;

import java.util.ArrayList;
import java.util.List;


public class LoopsVersion extends NameList
{
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

}
