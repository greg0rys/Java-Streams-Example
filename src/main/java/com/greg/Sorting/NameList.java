package com.greg.Sorting;

import java.util.*;

public class NameList
{
    protected final List<String> NAMES = new ArrayList<>();
    protected Map<String, Long> nameCounts = new HashMap<>();
    protected int numNames;
    protected long loopsRunTime, streamsRunTime;

    public NameList(List<String> nameData)
    {
        if(nameData.isEmpty()) nameData = new ArrayList<>();
        NAMES.addAll(nameData);
        numNames = (NAMES.size() - 1); // account for the start @ zero
    }

    public long getLoopsRunTime() { return loopsRunTime; }
    public long getStreamsRunTime() { return streamsRunTime; }

    protected void sortMap()
    {
        if(nameCounts.isEmpty()) return;

        nameCounts = new TreeMap<>(nameCounts);
    }

    public void printStats(long prog1, long prog2)
    {
        // let prog1 = loops version
        // let prog2 = streams version

        System.out.println("On a dataset of " + numNames + " names here are the results");
        System.out.println("***********************************************");

        System.out.println("LoopsVersion => " + prog1 + "ms\nStreamsVersion => " + prog2 + "ms");

        System.out.println("***********************************************");


    }

    public void display()
    {
        if(numNames <= 0)
            return;
        NAMES.forEach(System.out::println);
        System.out.println("I have a total of " + numNames + " in this List");
    }
}
