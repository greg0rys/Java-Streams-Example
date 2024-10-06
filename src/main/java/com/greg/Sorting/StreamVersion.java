package com.greg.Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamVersion extends NameList
{

    public StreamVersion(List<String> nameData)
    {
        super(nameData.isEmpty() ? new ArrayList<>() : nameData);
        countStream();
    }

    private void countStream()
    {
        long startTime = System.currentTimeMillis();

        if(NAMES.isEmpty()) return;

        // let's count the number of times a name appears in this list.
        nameCounts = NAMES.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        sortMap();

        long endTime = System.currentTimeMillis();
        streamsRunTime = endTime - startTime;
    }

    public long getStreamsTime() { return streamsRunTime; }

    @Override
    public void display()
    {
        System.out.println("Using Streams");
        System.out.printf("%-20s %-10s\n", "Name", "Count");
        System.out.println("--------------------------");
        nameCounts.forEach((name, count) -> System.out.printf("%-20s <=> %-10d\n", name, count));
        System.out.println();
    }


}
