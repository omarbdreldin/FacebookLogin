package com.omar.facebooklogintryout.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Omar on 5/21/2018.
 */

public interface ApiInterface {
    @GET("/photos")
    Call<List<Photo>> getPhotos();
}
