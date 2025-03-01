package com.example.mvvmexample.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmexample.models.SampleModel;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<SampleModel> data = new MutableLiveData<>();

    public LiveData<SampleModel> getData() {
        return data;
    }

    public void generateNextValue() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        SampleModel newData = new SampleModel(generatedString);
        data.postValue(newData);
    }
}
