package com.example.jayhind.lecture_app.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jay Hind on 6/29/2018.
 */

public class user {

    @SerializedName("name")
    private String username;

    @SerializedName("pass")
    private String password;

    public user(String username,String password)
    {
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
