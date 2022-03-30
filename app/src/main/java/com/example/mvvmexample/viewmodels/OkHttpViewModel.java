package com.example.projetandroid.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetandroid.models.PriceResponse;
import com.example.projetandroid.models.SampleModel;
import com.example.projetandroid.network.OkHttpNetworkManager;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpViewModel extends ViewModel {

    private final MutableLiveData<SampleModel> data = new MutableLiveData<>();

    public LiveData<SampleModel> getData() {
        return data;
    }

    public void generateNextValue() {
        OkHttpNetworkManager.INSTANCE.bitcoinPriceRequest().enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                // NO-OP
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.body() != null) {
                    try {
                        handleReponse(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void handleReponse(String responseString) {
        Gson gson = new Gson();
        PriceResponse entity = gson.fromJson(responseString, PriceResponse.class);
        if (entity != null && entity.getData() != null) {
            data.postValue(new SampleModel(entity.getData().getPrice()));
        }
    }
}
