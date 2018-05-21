package com.omar.facebooklogintryout.pojos;

/**
 * Created by Omar on 5/21/2018.
 */

public class User {
    private String id;
    private String name;
    private String email;
    private String fbImageUrl;

    public User(String id, String name, String email, String fbImageUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.fbImageUrl = fbImageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFbImageUrl() {
        return fbImageUrl;
    }

    public void setFbImageUrl(String fbImageUrl) {
        this.fbImageUrl = fbImageUrl;
    }
}
