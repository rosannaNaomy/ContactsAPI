package com.portillo.naomyportillo.contactsapi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.portillo.naomyportillo.contactsapi.recyclerview.UserHolder;

public class DetailActivity extends AppCompatActivity {

    private TextView detailyNameTextView;
    private TextView detailPhoneTextView;
    private TextView detailEmailTextView;
    private TextView detailAddressTextView;
    private String detailName;
    private String detailPhone;
    private String detailEmail;
    public String detailCity;
    public String detailSuite;
    public String detailZip;
    public String detailStreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        findViews();
        Intent intent = getIntent();
        extractData(intent);
        setViews();

    }

    private void setViews() {
        String address = detailSuite + " " + detailStreet + "\n"
                + detailCity + ", " + detailZip;
        detailyNameTextView.setText(detailName);
        detailPhoneTextView.setText(detailPhone);
        detailEmailTextView.setText(detailEmail);
        detailAddressTextView.setText(address);

        onClick();

        Log.d(".DETAILACTIVITY", "Nummy - " + detailSuite);
    }

    private void onClick() {
        detailPhoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (detailPhone.contains(" ")) {
                    detailPhone = detailPhone.substring(0, detailPhone.indexOf(" "));
                }
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + detailPhone));
                startActivity(intent);
            }
        });

        detailEmailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + detailEmail));
                startActivity(intent);

            }
        });
    }

    private void extractData(Intent intent) {
        detailName = intent.getStringExtra(UserHolder.USERNAME);
        detailPhone = intent.getStringExtra(UserHolder.USERPHONE);
        detailEmail = intent.getStringExtra(UserHolder.USEREMAIL);

        detailSuite = intent.getStringExtra(UserHolder.USERSUITE);
        detailStreet = intent.getStringExtra(UserHolder.USERSTREET);
        detailCity = intent.getStringExtra(UserHolder.USERCITY);
        detailZip = intent.getStringExtra(UserHolder.USERZIP);
    }

    private void findViews() {
        detailyNameTextView = findViewById(R.id.detail_name_textview);
        detailPhoneTextView = findViewById(R.id.detail_phone_textview);
        detailEmailTextView = findViewById(R.id.detail_email_textview);
        detailAddressTextView = findViewById(R.id.detail_adress_textview);
    }

}
