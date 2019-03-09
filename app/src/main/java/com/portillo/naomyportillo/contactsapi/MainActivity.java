package com.portillo.naomyportillo.contactsapi;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.portillo.naomyportillo.contactsapi.fragments.UserListFragment;
import com.portillo.naomyportillo.contactsapi.model.UserModel;
import com.portillo.naomyportillo.contactsapi.network.UserRetrofitSevice;
import com.portillo.naomyportillo.contactsapi.network.UserRetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserListFragment userListFragment = UserListFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.userlist_fragment_container, userListFragment).commit();

    }


}