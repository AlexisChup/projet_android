package com.example.projetandroid.viewmodels;

import androidx.lifecycle.LiveData;

import com.example.projetandroid.models.SampleModel;

public interface IViewModel {
    LiveData<SampleModel> getData();
    void generateNextValue();
    void fetch10FirstCrypto();
}
