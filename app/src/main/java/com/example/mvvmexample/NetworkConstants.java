package com.example.mvvmexample;

public class NetworkConstants {

    public static final String BASE_URL = "https://coinranking1.p.rapidapi.com";
    public static final String BITCOIN_PRICE_PATH = "/coin/Qwsogvtv82FCd/price";
    public static final String FIRST_10_PRICE_PATH = "/coins?referenceCurrencyUuid=yhjMzLPhuIDl&timePeriod=24h&tiers=1&orderBy=marketCap&orderDirection=desc&limit=10&offset=0";

    public static final String HOST_HEADER_NAME = "x-rapidapi-host";
    public static final String HOST_HEADER_VALUE = "coinranking1.p.rapidapi.com";
    public static final String KEY_HEADER_NAME = "x-rapidapi-key";
    public static final String KEY_HEADER_VALUE = "ddb5321305mshb114cb717ed3954p1cee6ejsn47d63d8e0686";
}
