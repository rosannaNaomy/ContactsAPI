package com.portillo.naomyportillo.contactsapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRetrofitSingleton {


    private static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance != null){
            return instance;
        }
        instance = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return instance;
    }

    private UserRetrofitSingleton(){}
}
