package com.example.mvvmexample.models;

public class ListResponse extends GenericResponse {

    private CoinsData data;

    public CoinsData getData() {
        return data;
    }

    public void setData(CoinsData data) {
        this.data = data;
    }
}
