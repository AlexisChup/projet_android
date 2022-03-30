package com.example.projetandroid.network;

import com.example.projetandroid.NetworkConstants;
import com.example.projetandroid.models.ListResponse;
import com.example.projetandroid.models.PriceResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

// https://square.github.io/retrofit/
public interface CoinRankingAPI {

    @Headers({
            "x-rapidapi-host: coinranking1.p.rapidapi.com",
            "x-rapidapi-key: efeaa5d79fmshe6fa6c8e321ac1dp1b25afjsnf399ab057be2"
    })
    @GET(NetworkConstants.BITCOIN_PRICE_PATH)
    Call<PriceResponse> getBitcoinPrice();

    @Headers({
            "x-rapidapi-host: coinranking1.p.rapidapi.com",
            "x-rapidapi-key: efeaa5d79fmshe6fa6c8e321ac1dp1b25afjsnf399ab057be2"
    })
    @GET(NetworkConstants.FIRST_10_PRICE_PATH)
    Call<ListResponse> get10FirstCryptos();
}
