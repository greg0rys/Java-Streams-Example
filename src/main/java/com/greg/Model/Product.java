package com.greg.Model;

public class Product
{
    private int productID, productStock;
    private String name, category;
    private double price;

    public Product() { }

    public Product(int productID, int productStock, String name, String category)
    {
        this.productID = productID;
        this.productStock = productStock;
        this.name = name;
        this.category = category;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "Product { ID=> " + productID + " NAME=> " + name + " CATEGORY=> " + category + " STOCK=> " + productStock + " }";
    }
}
