package com.greg.Model;

public class Order
{
    private int orderID, userID, productID, productQuantity;

    public Order() { }

    public Order(int orderID, int userID, int productID, int productQuantity)
    {
        this.orderID = orderID;
        this.userID = userID;
        this.productID = productID;
        this.productQuantity = productQuantity;
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString()
    {
        return "Order { ID=> " + orderID + " USER ID=> " + userID + " PRODUCT ID=> " + productID + " QUANTITY=> " + productQuantity + " }";

    }
}
