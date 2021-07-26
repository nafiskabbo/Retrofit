package com.kabbodev.json.data.remote.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.kabbodev.json.data.remote.api.ApiClient;
import com.kabbodev.json.data.remote.api.ApiInterface;
import com.kabbodev.json.data.remote.response.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private final ArrayList<User> userList = new ArrayList<>();
    private final MutableLiveData<ArrayList<User>> userListLiveData = new MutableLiveData<>();

    public MutableLiveData<ArrayList<User>> getUserList() {
        if (userList.isEmpty()) {
            loadUserList();
        }
        userListLiveData.setValue(userList);
        return userListLiveData;
    }

    public void loadUserList() {
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<User>> call = apiInterface.getContacts();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    userList.clear();
                    if (response.body() != null) {
                        userList.addAll(response.body());
                    }
                    userListLiveData.postValue(userList);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("AYAN", "Error " + t.getMessage());
            }
        });
    }


}
