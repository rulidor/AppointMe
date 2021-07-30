package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointme.ServiceProvider.ServiceProvider;
import com.example.appointme.User.User;
import com.example.appointme.User.UserController;

public class BecomeProviderActivity extends AppCompatActivity {

    private UserController userController = UserController.getInstance();

    private TextView becOccupation;
    private TextView becFirstName;
    private TextView becLastName;
    private TextView becPhoneNumber;
    private TextView becAddress;
    private TextView becDescription;
    private Button btnBecomeProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_become_provider);

        becOccupation = (TextView) findViewById(R.id.becOccupation);
        becFirstName = (TextView) findViewById(R.id.becFirstName);
        becLastName = (TextView) findViewById(R.id.becLastName);
        becPhoneNumber = (TextView) findViewById(R.id.becPhoneNumber);
        becAddress = (TextView) findViewById(R.id.becAddress);
        becDescription  = (TextView) findViewById(R.id.becDescription);
        btnBecomeProvider = (Button) findViewById(R.id.btnBecomeProvider);

        btnBecomeProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(becOccupation.getText().toString().isEmpty() || becFirstName.getText().toString().isEmpty() ||
                becLastName.getText().toString().isEmpty() || becPhoneNumber.getText().toString().isEmpty() ||
                becAddress.getText().toString().isEmpty() || becDescription.getText().toString().isEmpty()){
                    Toast.makeText(BecomeProviderActivity.this, "Some fields are empty",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = userController.getUserMap().get(getIntent().getStringExtra("username"));
                user.setServiceProvider(true);
                ServiceProvider serviceProvider = new ServiceProvider(becOccupation.getText().toString(),
                        becFirstName.getText().toString(), becLastName.getText().toString(), becPhoneNumber.getText().toString(),
                        becAddress.getText().toString(), becDescription.getText().toString());
                user.setServiceProvider(serviceProvider);
                Toast.makeText(BecomeProviderActivity.this, "Congrats! You are now a SERVICE PROVIDER!",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getBaseContext(), MenuActivity.class);
                intent.putExtra("username", user.getUsername());
                startActivity(intent);
            }
        });

    }
}