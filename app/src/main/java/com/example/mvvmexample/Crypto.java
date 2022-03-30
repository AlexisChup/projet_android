package com.example.mvvmexample;

public class Crypto  {
    private String cryptoName;
    private String cryptoPrice;

    public Crypto(String cryptoName, String cryptoPrice) {
        this.cryptoName = cryptoName;
        this.cryptoPrice = cryptoPrice;
    }

    public void setName(String name) {
        this.cryptoName = name;
    }

    public void setPrice(String price) {
        this.cryptoPrice = price;
    }

    public String getCryptoName() {
        return this.cryptoName;
    }

    public String getCryptoPrice() {
        return this.cryptoPrice;
    }
}
