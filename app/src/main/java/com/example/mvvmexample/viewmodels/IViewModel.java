package com.example.mvvmexample.viewmodels;

import androidx.lifecycle.LiveData;

import com.example.mvvmexample.models.CoinsData;
import com.example.mvvmexample.models.SampleModel;

public interface IViewModel {
    LiveData<SampleModel> getData();
    LiveData<CoinsData> getCoinsData();

    void generateNextValue();
    void fetch10FirstCrypto();
}
