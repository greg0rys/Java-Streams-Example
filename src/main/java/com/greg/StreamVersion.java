package com.greg;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamVersion extends NameList
{

    public StreamVersion(List<String> nameData)
    {
        super(nameData.isEmpty() ? new ArrayList<>() : nameData);
        streamData();
    }

    private void streamData()
    {
        if(NAMES.isEmpty()) return;

        // let's count the number of times a name appears in this list.
        nameCounts = NAMES.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
    }


    @Override
    public void display()
    {
        if(NAMES.isEmpty())
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
