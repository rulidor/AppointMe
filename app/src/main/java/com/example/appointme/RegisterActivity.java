package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView regUsername;
    private TextView regPassword;
    private TextView regRepeatPass;
    private TextView regEmail;
    private TextView regPhone;
    private TextView regTermsAndConditions;
    private CheckBox regCheckBoxIAgree;
    private Button regBtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regTermsAndConditions = (TextView)findViewById(R.id.regTerms);
        regTermsAndConditions.setMovementMethod(new ScrollingMovementMethod());

        regUsername = (TextView)findViewById(R.id.regUsername);
        regPassword = (TextView)findViewById(R.id.regPassword);
        regRepeatPass = (TextView)findViewById(R.id.regRepeatPassword);
        regEmail = (TextView)findViewById(R.id.regEmail);
        regPhone = (TextView)findViewById(R.id.regPhone);
        regBtnSignUp = (Button) findViewById(R.id.btnLogin);

        regBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
//                startActivity(intent);
            }
        });


    }
}