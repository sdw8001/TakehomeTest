package com.example.takehometest.apilist;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by 서대원 on 2017-04-13.
 */

public interface GithubService {
    //API) https://api.github.com/users
    @GET("users")
    Call<List<GithubUser>> getGithubUsers();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
