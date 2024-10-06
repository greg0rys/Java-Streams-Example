package com.greg.Model;


import java.util.List;
import java.util.Map;

public class User
{
    private int userID, age;
    private String name, email;
    private Map<User, Order> usersOrders; // maybe put this in the
    // stream class. e.g. mapOrders()

    public User() { }

    public User(int userID, int age, String name, String email)
    {
        this.userID = userID;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString()
    {
        return "User { ID=> " + userID + " NAME=> " + name + " AGE=> " + age + " EMAIL=> " + email + " }";
    }


}