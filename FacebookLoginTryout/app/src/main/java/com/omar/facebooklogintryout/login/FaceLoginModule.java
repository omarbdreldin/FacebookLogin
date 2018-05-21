package com.omar.facebooklogintryout.login;

import android.content.Context;

import com.omar.facebooklogintryout.retrofit.ApiModel;
import com.omar.facebooklogintryout.retrofit.PhotoApiModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Omar on 5/20/2018.
 */
@Module
public class FaceLoginModule {

    @Provides
    FaceLoginMVP.Presenter providePresenter(FaceLoginMVP.Model model, ApiModel apiModel) {
        return new FaceLoginPresenter(model, apiModel);
    }

    @Provides
    FaceLoginMVP.Model provideModel(Context context) {
        return new FaceLoginModel(context);
    }

    @Provides
    ApiModel provideApiModel() {
        return new PhotoApiModel();
    }
}
