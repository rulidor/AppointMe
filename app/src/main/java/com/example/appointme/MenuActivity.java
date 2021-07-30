package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView mTxtProviderOrClient;
    private ImageView mImgClientOrProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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
    }
}