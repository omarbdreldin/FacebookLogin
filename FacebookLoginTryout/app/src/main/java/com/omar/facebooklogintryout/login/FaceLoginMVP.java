package com.omar.facebooklogintryout.login;

import android.content.Context;
import android.content.Intent;

import com.omar.facebooklogintryout.retrofit.Photo;

import java.util.List;

/**
 * Created by Omar on 5/19/2018.
 */

public interface FaceLoginMVP {

    public interface Model {

        void registerCallBackForFaceLogin();
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    public interface View {

    }

    public interface Presenter {

        void setView(View view);
        void terminate();
        void registerCallBackForFaceLogin();
        void onActivityResult(int requestCode, int resultCode, Intent data);

        void getButtonPressedAction();
    }
}
