package com.portillo.naomyportillo.contactsapi.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.portillo.naomyportillo.contactsapi.R;
import com.portillo.naomyportillo.contactsapi.model.UserModel;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {

    List<UserModel> userModels;

    public UserAdapter(List<UserModel> userModels) {
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_item_recycler, viewGroup, false);
        return new UserHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int pos) {
        UserModel userModel = userModels.get(pos);
        UserHolder.onBind(userModel);
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }
}
