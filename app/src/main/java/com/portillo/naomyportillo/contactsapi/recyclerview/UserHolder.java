package com.portillo.naomyportillo.contactsapi.recyclerview;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.portillo.naomyportillo.contactsapi.DetailActivity;
import com.portillo.naomyportillo.contactsapi.R;
import com.portillo.naomyportillo.contactsapi.model.UserModel;

public class UserHolder extends RecyclerView.ViewHolder {

    public static final String USERNAME = "name";
    public static final String USERPHONE = "phone";
    public static final String USEREMAIL = "email";
    public static final String USERADDRESS = "address";
    public static final String USERCITY = "city";
    public static final String USERSUITE= "suite";
    public static final String USERZIP = "zip";
    public static final String USERSTREET = "street";
    private static CardView userCardview;
    private static TextView userNameTextView;
    private static Bundle address;

    public UserHolder(@NonNull View itemView) {
        super(itemView);

        this.userCardview = itemView.findViewById(R.id.user_card);
        this.userNameTextView = itemView.findViewById(R.id.user_name);
    }


    public static void onBind(final UserModel userModel){
        userNameTextView.setText(userModel.getName());

        Log.d(".USERHOLDER", "Nummy - " + userModel.getAddress().getSuite());

        userCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(userCardview.getContext(), DetailActivity.class);

                intent.putExtra(USERNAME, userModel.getName());
                intent.putExtra(USERPHONE, userModel.getPhoneNumber());
                intent.putExtra(USEREMAIL, userModel.getEmail());
                intent.putExtra(USERSUITE, userModel.getAddress().getSuite());
                intent.putExtra(USERSTREET, userModel.getAddress().getStreet());
                intent.putExtra(USERCITY, userModel.getAddress().getCity());
                intent.putExtra(USERZIP, userModel.getAddress().getZipcode());
                userCardview.getContext().startActivity(intent);
            }
        });
    }

}
