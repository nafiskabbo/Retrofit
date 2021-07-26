package com.kabbodev.json.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kabbodev.json.R;
import com.kabbodev.json.data.remote.response.User;
import com.kabbodev.json.ui.adapter.UserAdapter;
import com.kabbodev.json.ui.viewModels.UserViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        UserViewModel userViewModel = new ViewModelProvider(this, factory).get(UserViewModel.class);

        userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);

        userViewModel.loadUserList().observe(this, users -> {
            if (users != null) {
                userAdapter.updateList(users);
            }
        });

    }

}