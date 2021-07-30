package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointme.User.User;
import com.example.appointme.User.UserController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private UserController userController = UserController.getInstance();

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
        regCheckBoxIAgree = (CheckBox) findViewById(R.id.regCheckBoxIAgree);
        regBtnSignUp = (Button) findViewById(R.id.regSignUp);

        regBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCorrectDetails() == false)
                    return;

                //check the "I agree" check box
                if( !regCheckBoxIAgree.isChecked() ){
                    Toast.makeText(RegisterActivity.this, "You must agree to terms and conditions in order to continue",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                User user = new User(regUsername.getText().toString(), regPassword.getText().toString(), regEmail.getText().toString(),
                        false, regPhone.getText().toString(), false);
                userController.getUserMap().put(regUsername.getText().toString(), user);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean isUserAlreadyExist() {
        return userController.getUserMap().containsKey(regUsername);
    }

    private boolean isEmailAlreadyExist() {
        for (User u : userController.getUserMap().values() ) {
            if(u.getEmail().equals(regEmail))
                return true;
        }
        return false;
    }

    public boolean isCorrectDetails(){

        //check username and password
        if( regUsername.getText().toString().isEmpty() || regPassword.getText().toString().isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Username or password cannot be empty",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        //check email
        if( regEmail.getText().toString().isEmpty() ) {
            Toast.makeText(RegisterActivity.this, "Email cannot be empty",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else{ //check email validity
            if( !isValidEmailAddress(regEmail.getText().toString()) ){
                Toast.makeText(RegisterActivity.this, "Wrong email",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        //check phone
        if( regPhone.getText().toString().isEmpty() ) {
            Toast.makeText(RegisterActivity.this, "Phone number cannot be empty",
                    Toast.LENGTH_SHORT).show();
            return false;
        }else{ //check phone validity
            if( !isValidPhone(regPhone.getText().toString()) ){
                Toast.makeText(RegisterActivity.this, "Wrong phone number",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        if( !regPassword.getText().toString().equals(regRepeatPass.getText().toString()) ){
            Toast.makeText(RegisterActivity.this, "Please repeat password correctly",
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        //todo: check if these 2 addons are alright:
        if ( isUserAlreadyExist() ){
            Toast.makeText(RegisterActivity.this, "Username already exist",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if ( isEmailAlreadyExist() ){
            Toast.makeText(RegisterActivity.this, "Email already exist",
                    Toast.LENGTH_SHORT).show();
            return false;
        }


        //details are ok
        return true;
    }

    private boolean isValidEmailAddress(String email) {
//        return EmailValidator.getInstance().isValid(email);
        return true;
    }

    private boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile("\\d{3}\\d{7}");
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches())
            return true;
        return false;
    }
}