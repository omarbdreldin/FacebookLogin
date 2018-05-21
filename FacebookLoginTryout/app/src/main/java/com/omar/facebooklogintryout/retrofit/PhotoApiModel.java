package com.omar.facebooklogintryout.retrofit;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Omar on 5/21/2018.
 */

public class PhotoApiModel implements ApiModel {

    @Override
    public List<Photo> downloadPhotosList() {
        ApiInterface apiClient = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Photo>> call = apiClient.getPhotos();
        call.enqueue(new Callback());
        return null;
    }

    private class Callback implements retrofit2.Callback<List<Photo>> {

        @Override
        public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
            List<Photo> photos = response.body();
            Log.i("myTag", photos.get(0).getUrl());
        }

        @Override
        public void onFailure(Call<List<Photo>> call, Throwable t) {

        }
    }
}
