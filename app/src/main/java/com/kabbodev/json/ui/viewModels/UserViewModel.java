package com.kabbodev.json.ui.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kabbodev.json.data.remote.repository.UserRepository;
import com.kabbodev.json.data.remote.response.User;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {

    private final UserRepository userRepository = new UserRepository();

    public LiveData<ArrayList<User>> loadUserList() {
        return userRepository.getUserList();
    }

}
