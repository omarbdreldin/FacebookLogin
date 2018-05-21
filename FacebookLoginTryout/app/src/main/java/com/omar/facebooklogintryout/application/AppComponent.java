package com.omar.facebooklogintryout.application;

import com.omar.facebooklogintryout.login.FaceLoginActivity;
import com.omar.facebooklogintryout.login.FaceLoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Omar on 5/20/2018.
 */
@Singleton
@Component(modules = {AppModule.class, FaceLoginModule.class})
public interface AppComponent {
    void inject(FaceLoginActivity activity);
}
