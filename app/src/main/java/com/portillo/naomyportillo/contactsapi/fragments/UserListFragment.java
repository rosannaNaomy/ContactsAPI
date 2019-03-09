package com.portillo.naomyportillo.contactsapi.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.portillo.naomyportillo.contactsapi.R;
import com.portillo.naomyportillo.contactsapi.model.UserModel;
import com.portillo.naomyportillo.contactsapi.network.UserRetrofitSevice;
import com.portillo.naomyportillo.contactsapi.network.UserRetrofitSingleton;
import com.portillo.naomyportillo.contactsapi.recyclerview.UserAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserListFragment extends Fragment {

    List<UserModel> userList;
    private static final String TAG = ".USERLISTFRAGMENT";
    RecyclerView userListRecyclerView;

    public UserListFragment() {
    }

    public static UserListFragment newInstance() {
        return new UserListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofitCall();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userListRecyclerView = view.findViewById(R.id.user_recycler_container);
    }

    private void retrofitCall() {
        Retrofit retrofit = UserRetrofitSingleton.getInstance();
        UserRetrofitSevice userRetrofitSevice = retrofit.create(UserRetrofitSevice.class);
        Call<List<UserModel>> userModelCall = userRetrofitSevice.getUser();
        userModelCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                userList = response.body();

                Log.d(TAG, "Nummy - This retrofit call was successful " + response.body().toString());
                Log.d(TAG, "Nummy - " + userList.get(0));

                rvSetup();
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                Log.d(TAG, "Nummy - On Failure, This retrofit call was not successful" + t.getMessage());

            }
        });
    }

    private void rvSetup() {
        userListRecyclerView.setAdapter(new UserAdapter(userList));
        userListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
