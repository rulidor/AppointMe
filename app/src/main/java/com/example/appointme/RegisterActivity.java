package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView regTermsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regTermsAndConditions = (TextView)findViewById(R.id.regTerms);
        regTermsAndConditions.setMovementMethod(new ScrollingMovementMethod());


    }
}