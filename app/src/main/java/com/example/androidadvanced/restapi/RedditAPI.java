package com.example.androidadvanced.restapi;

import com.example.androidadvanced.entities.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RedditAPI {

    @Headers("Content-type: applicaiton/json")
    @GET(".json")
    Call<Feed> getData();
}
