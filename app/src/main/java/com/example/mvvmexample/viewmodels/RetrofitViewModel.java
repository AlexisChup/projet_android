package com.example.projetandroid.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.projetandroid.models.ListResponse;
import com.example.projetandroid.models.PriceResponse;
import com.example.projetandroid.models.SampleModel;
import com.example.projetandroid.network.RetrofitNetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitViewModel extends ViewModel implements IViewModel {

    private final MutableLiveData<SampleModel> data = new MutableLiveData<>();

    public LiveData<SampleModel> getData() {
        return data;
    }

    @Override
    public void generateNextValue() {
        RetrofitNetworkManager.coinRankingAPI.getBitcoinPrice().enqueue(new Callback<PriceResponse>() {
            @Override
            public void onResponse(Call<PriceResponse> call, Response<PriceResponse> response) {
                if (response.body() != null) {
                    handleResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<PriceResponse> call, Throwable t) {
                // NO-OP
            }
        });
    }

    @Override
    public void fetch10FirstCrypto() {
        RetrofitNetworkManager.coinRankingAPI.get10FirstCryptos().enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                if (response.body() != null) {
                    handleResponseList(response.body());
                }
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                // NO-OP
            }
        });
    }

    private void handleResponseList(ListResponse response) {
        data.postValue(new SampleModel(response.getData().getCoinList().get(0).getName()));
    }

    private void handleResponse(PriceResponse response) {
        data.postValue(new SampleModel(response.getData().getPrice()));
    }
}