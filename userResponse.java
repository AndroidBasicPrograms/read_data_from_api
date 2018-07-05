package com.example.jayhind.lecture_app.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jay Hind on 6/29/2018.
 */

public class userResponse {
    @SerializedName("data")
    private List<user> data;

    public List<user> getData() {
        return data;
    }

    public void setData(List<user> data) {
        this.data = data;
    }
}
