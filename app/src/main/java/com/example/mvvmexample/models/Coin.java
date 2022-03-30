package com.example.mvvmexample.models;

public class Coin {
    private String name;
    private String price;

    public Coin(String nameS, String priceS) {
        name = nameS;
        price = priceS;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
