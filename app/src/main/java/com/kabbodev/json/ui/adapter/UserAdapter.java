package com.kabbodev.json.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kabbodev.json.data.remote.response.User;
import com.kabbodev.json.databinding.ItemUserBinding;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    public final ArrayList<User> items = new ArrayList<>();

    public UserAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = items.get(position);
        if (position % 7 == 0) {
            holder.binding.name.setText(user.getName());
        }
        holder.binding.phone.setText(user.getPhone());
        Glide
                .with(holder.binding.getRoot().getContext())
                .load(user.getImage())
                .into(holder.binding.userImg);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateList(List<User> updated) {
        items.clear();
        items.addAll(updated);
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding binding;

        public MyViewHolder(@NonNull ItemUserBinding viewBinding) {
            super(viewBinding.getRoot());
            binding = viewBinding;
        }
    }

}