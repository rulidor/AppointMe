package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointme.User.UserController;

public class MenuActivity extends AppCompatActivity {

    private UserController userController = UserController.getInstance();

    private ImageView mBtnLogout;
    private LinearLayout layNewAppointment;
    private LinearLayout layMyAppointments;
    private LinearLayout layMyProfile;
    private LinearLayout laySettings;
    private LinearLayout layOfferServiceOrManageYours;

    private TextView mTxtProviderOrClient;
    private ImageView mImgClientOrProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mBtnLogout = (ImageView) findViewById(R.id.mBtnLogout);
        layNewAppointment = (LinearLayout)findViewById(R.id.layNewAppointment);
        layMyAppointments = (LinearLayout)findViewById(R.id.layMyAppointments);
        layMyProfile = (LinearLayout)findViewById(R.id.layMyProfile);
        laySettings = (LinearLayout)findViewById(R.id.laySettings);
        layOfferServiceOrManageYours = (LinearLayout)findViewById(R.id.layOfferServiceOrManageYours);

        mTxtProviderOrClient = (TextView) findViewById(R.id.clientOrProvider);
        mImgClientOrProvider = (ImageView) findViewById(R.id.imgClientOrProvider);

        boolean isProvider = getIntent().getBooleanExtra("isServiceProvide", false);
        if(isProvider){
            mTxtProviderOrClient.setText("Manage Calendar");
            mImgClientOrProvider.setImageResource(R.drawable.manage_your_calendar);

        }
        else{
            mTxtProviderOrClient.setText("Offer Your Service");
            mImgClientOrProvider.setImageResource(R.drawable.offer_your_service);
        }

        mBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = getIntent().getStringExtra("username");
                userController.getUserMap().get(username).setLoggedIn(false);
                Toast.makeText(MenuActivity.this, "Logged out",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        layNewAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        layMyAppointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        layMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        laySettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        layOfferServiceOrManageYours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}