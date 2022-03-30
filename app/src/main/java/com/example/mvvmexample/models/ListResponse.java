package com.example.mvvmexample.models;

public class ListRepsponse extends GenericResponse {
    private CoinData data;

    public CoinData getData() {
        return data;
    }

    public void setData(CoinData data) {
        this.data = data;
    }
}
