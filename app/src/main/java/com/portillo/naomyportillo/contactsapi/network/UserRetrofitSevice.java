package com.portillo.naomyportillo.contactsapi.network;

import com.portillo.naomyportillo.contactsapi.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface UserRetrofitSevice {

    String ENDPOINT = "users";

    @GET(ENDPOINT)
    Call<List<UserModel>> getUser();
}
