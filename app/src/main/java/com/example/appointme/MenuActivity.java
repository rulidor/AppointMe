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

import com.example.appointme.User.User;
import com.example.appointme.User.UserController;

public class MenuActivity extends AppCompatActivity {

    private UserController userController = UserController.getInstance();

    private User currentUser;
    private String username;

    private ImageView mBtnLogout;
    private LinearLayout layNewAppointment;
    private LinearLayout layMyAppointments;
    private LinearLayout layMyProfile;
    private LinearLayout laySettings;
    private LinearLayout layOfferServiceOrManageYours;

    private TextView mTxtProviderOrClient;
    private ImageView mImgClientOrProvider;
    private TextView txtDashboard;

    @Override
    protected void onResume() {
        super.onResume();
        username = getIntent().getStringExtra("username");
        if( !username.isEmpty() )
            currentUser = userController.getUserMap().get(username);
        boolean isProvider = currentUser.isServiceProvider();
        if(isProvider){
            mTxtProviderOrClient.setText("Manage Calendar");
            mImgClientOrProvider.setImageResource(R.drawable.manage_your_calendar);

        }
        else{
            mTxtProviderOrClient.setText("Offer Your Service");
            mImgClientOrProvider.setImageResource(R.drawable.offer_your_service);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        currentUser = userController.getUserMap().get(getIntent().getStringExtra("username"));

        mBtnLogout = (ImageView) findViewById(R.id.mBtnLogout);
        layNewAppointment = (LinearLayout)findViewById(R.id.layNewAppointment);
        layMyAppointments = (LinearLayout)findViewById(R.id.layMyAppointments);
        layMyProfile = (LinearLayout)findViewById(R.id.layMyProfile);
        laySettings = (LinearLayout)findViewById(R.id.laySettings);
        layOfferServiceOrManageYours = (LinearLayout)findViewById(R.id.layOfferServiceOrManageYours);

        mTxtProviderOrClient = (TextView) findViewById(R.id.clientOrProvider);
        mImgClientOrProvider = (ImageView) findViewById(R.id.imgClientOrProvider);

        txtDashboard = (TextView) findViewById(R.id.txtDashboard);
        txtDashboard.setText(txtDashboard.getText().toString() + " - " +this.currentUser.getUsername());


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
                String username = getIntent().getStringExtra("username");
                Intent intent = new Intent(getBaseContext(), MyProfileActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
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
                String username = getIntent().getStringExtra("username");
                Intent intent = new Intent(getBaseContext(), BecomeProviderActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}