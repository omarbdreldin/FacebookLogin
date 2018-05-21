package com.omar.facebooklogintryout.application;

import android.app.Application;

import com.omar.facebooklogintryout.login.FaceLoginModule;

/**
 * Created by Omar on 5/20/2018.
 */

public class App extends Application {

    private AppComponent component;

    public AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .faceLoginModule(new FaceLoginModule())
                .build();
    }
}
