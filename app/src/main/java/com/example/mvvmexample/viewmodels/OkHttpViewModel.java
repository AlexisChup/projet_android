package com.example.mvvmexample.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmexample.models.CoinsData;
import com.example.mvvmexample.models.ListResponse;
import com.example.mvvmexample.models.PriceResponse;
import com.example.mvvmexample.models.SampleModel;
import com.example.mvvmexample.network.OkHttpNetworkManager;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpViewModel extends ViewModel {

    private final MutableLiveData<SampleModel> data = new MutableLiveData<>();
    private final MutableLiveData<CoinsData> coinsData = new MutableLiveData<>();

    public LiveData<SampleModel> getData() {
        return data;
    }
    public LiveData<CoinsData> getCoinsData() { return coinsData; }

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

    public void fetch10first() {
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
                        handleReponseFirst10(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void handleReponseFirst10(String responseString) {
        Gson gson = new Gson();
        ListResponse entity = gson.fromJson(responseString, ListResponse.class);
        if (entity != null && entity.getData() != null) {
            coinsData.postValue(entity.getData());
        }
    }

    private void handleReponse(String responseString) {
        Gson gson = new Gson();
        PriceResponse entity = gson.fromJson(responseString, PriceResponse.class);
        if (entity != null && entity.getData() != null) {
            data.postValue(new SampleModel(entity.getData().getPrice()));
        }
    }
}
