package com.greg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameList
{
    protected final List<String> NAMES = new ArrayList<>();
    protected Map<String, Long> nameCounts = new HashMap<>();
    protected int numNames;

    public NameList(List<String> nameData)
    {
        if(nameData.isEmpty()) nameData = new ArrayList<>();

        NAMES.addAll(nameData);
        numNames = (NAMES.size() - 1); // account for the start @ zero
    }


    public int getNumNames() { return numNames; }

    public void display()
    {
        if(numNames <= 0)
            return;
        NAMES.forEach(System.out::println);
        System.out.println("I have a total of " + numNames + " in this List");
    }
}
