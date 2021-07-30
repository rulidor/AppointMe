package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appointme.User.User;
import com.example.appointme.User.UserController;

public class MyProfileActivity extends AppCompatActivity {

    private UserController userController = UserController.getInstance();

    private TextView profUsername;
    private TextView profEmail;
    private TextView profIsProvider;
    private TextView profPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        User user = userController.getUserMap().get(getIntent().getStringExtra("username"));

        profUsername = (TextView)findViewById(R.id.profUsername);
        profEmail = (TextView)findViewById(R.id.profEmail);
        profIsProvider = (TextView)findViewById(R.id.profIsProvider);
        profPhoneNumber = (TextView)findViewById(R.id.profPhoneNumber);

        profUsername.setText(user.getUsername());
        profEmail.setText(user.getEmail());
        if(user.isServiceProvider())
            profIsProvider.setText("Yes");
        else
            profIsProvider.setText("No");
        profPhoneNumber.setText(user.getPhone());
    }
}