package com.simplyillustrate.retrofitpostexample.services;

public class APIUtils {

    private APIUtils() {

    }

    public static final String BASE_URL = "http://172.20.10.3:3000/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
