package com.example.mvvmexample.models;

import java.util.List;

public class CoinsData {
    private List<Coin> coins;

    public List<Coin> getCoinList() {
        return coins;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coins = coinList;
    }
}
