package com.omar.facebooklogintryout.login;

import android.content.Intent;
import android.util.Log;

import com.omar.facebooklogintryout.retrofit.ApiModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Omar on 5/20/2018.
 */

public class FaceLoginPresenter implements FaceLoginMVP.Presenter {

    FaceLoginMVP.View view;
    FaceLoginMVP.Model model;
    ApiModel apiModel;

    public FaceLoginPresenter(FaceLoginMVP.Model model, ApiModel apiModel) {
        this.model = model;
        this.apiModel = apiModel;
        EventBus.getDefault().register(this);
    }

    @Override
    public void setView(FaceLoginMVP.View view) {
        this.view = view;
    }

    @Override
    public void terminate() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void registerCallBackForFaceLogin() {
        model.registerCallBackForFaceLogin();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        model.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void getButtonPressedAction() {
        apiModel.downloadPhotosList();
    }

    @Subscribe
    public void onFaceLoginMessegeSent(FaceLoginModel.FaceLoginMessage message) {
    }
}
