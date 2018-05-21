package com.omar.facebooklogintryout.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.omar.facebooklogintryout.pojos.User;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

/**
 * Created by Omar on 5/20/2018.
 */

public class FaceLoginModel implements FaceLoginMVP.Model {

    @Inject
    Context context;
    private CallbackManager manager;

    public FaceLoginModel(Context context) {
        this.context = context;
        manager = CallbackManager.Factory.create();
    }

    @Override
    public void registerCallBackForFaceLogin() {
        LoginManager.getInstance().registerCallback(manager, new FaceLoginCallback());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        manager.onActivityResult(requestCode, resultCode, data);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private class FaceLoginCallback implements FacebookCallback<LoginResult> {

        @Override
        public void onSuccess(LoginResult loginResult) {
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                    JSONObject json = response.getJSONObject();
                    try {
                        if (json != null) {
                            User user = new User(json.getString("id")
                                    , json.getString("name")
                                    , json.getString("email")
                                    , json.getString("picture"));
                            FaceLoginMessage message = new FaceLoginMessage(user);
                            EventBus.getDefault().post(message);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,link,email,picture");
            request.setParameters(parameters);
            request.executeAsync();
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException error) {

        }
    }

    public class FaceLoginMessage {
        private User user;

        public FaceLoginMessage(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}
