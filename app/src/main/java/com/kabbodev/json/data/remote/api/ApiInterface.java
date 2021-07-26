package com.kabbodev.json.data.remote.api;

import com.kabbodev.json.data.remote.response.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("contacts.json")
    Call<List<User>> getContacts();

}
