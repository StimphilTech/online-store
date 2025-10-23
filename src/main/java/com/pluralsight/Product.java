package com.pluralsight;

public class Product {
    public String id;
    private String name;
    private double price;

    public Product (String id, String name, double price){


    }

    public Product(String id, String name, String price) {
        this.id = "";
        this.name = "";
        this.price = 0;
    }

//    public CellPhone() {
//        serialNumber = 0;
//        model = "";
//        carrier = "";
//        phoneNumber = "";
//        owner = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return "$" + this.price;
    }

    public void setPrice(double price) {
        this.price = price;

        if (price < 0) {
            System.out.println("Price can't be less than zero");
        }

        else {
            this.price = price;
        }
    }


    public double setPrice() {
        return 0;

    }




}





