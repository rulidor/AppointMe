package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointme.User.User;
import com.example.appointme.User.UserController;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText mUsername, mPassword;
    private Button btnLogin;
    private CheckBox mCheckboxPref;
    private TextView mSignup;

    private UserController userController = UserController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsername = (EditText)findViewById(R.id.mUsername);
        mPassword = (EditText)findViewById(R.id.mPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        mSignup = (TextView)findViewById(R.id.mSignup);
        mCheckboxPref = (CheckBox)findViewById(R.id.mCheckBoxPref);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        checkSharedPreferences();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mUsername.getText().toString().isEmpty() || mPassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username or password cannot be empty",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                //save checkbox preference
                if(mCheckboxPref.isChecked()){
                    editor.putString(getString(R.string.checkbox), "True");
                    editor.commit();

                    //save username
                    String username = mUsername.getText().toString();
                    editor.putString(getString(R.string.username), username);
                    editor.commit();

                    //save password;
                    String password = mPassword.getText().toString();
                    editor.putString(getString(R.string.password),password);
                    editor.commit();
                }
                else{
                    editor.putString(getString(R.string.checkbox), "False");
                    editor.commit();

                    //save username
                    editor.putString(getString(R.string.username), "");
                    editor.commit();

                    //save password;
                    editor.putString(getString(R.string.password),"");
                    editor.commit();
                }

                User user = checkLoginDetails();
                if (user != null){
                    user.setLoggedIn(true);
                    userController.getUserMap().put(user.getUsername(), user);
                    Intent intent = new Intent(getBaseContext(), MenuActivity.class);
                    intent.putExtra("username", mUsername.getText().toString());

                    if(user.isServiceProvider() == false){
                        intent.putExtra("isServiceProvide", false);
                    }
                    else{
                        intent.putExtra("isServiceProvide", true);
                    }
                    startActivity(intent);
                }

            }
        });

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private User checkLoginDetails() {
        if (!userController.getUserMap().keySet().contains(mUsername.getText().toString())){
            Toast.makeText(MainActivity.this, "Wrong details",
                    Toast.LENGTH_LONG).show();
            return null;
        }
        if(!userController.getUserMap().get(mUsername.getText().toString()).getPassword().equals(
                mPassword.getText().toString())) {//wrong password
            Toast.makeText(MainActivity.this, "Wrong details",
                    Toast.LENGTH_LONG).show();
            return null;
        }
        if(userController.getUserMap().get(mUsername.getText().toString()).isLoggedIn()) {//user already logged in
            Toast.makeText(MainActivity.this, "User already logged in",
                    Toast.LENGTH_LONG).show();
            return null;
        }
        //case correct details
        return userController.getUserMap().get(mUsername.getText().toString());
    }

    private void checkSharedPreferences(){
        String checkbox = preferences.getString(getString(R.string.checkbox), "False");
        String username = preferences.getString(getString(R.string.username), "");
        String password = preferences.getString(getString(R.string.password), "");

        mUsername.setText(username);
        mPassword.setText(password);

        if(checkbox.equals("True"))
            mCheckboxPref.setChecked(true);
        else
            mCheckboxPref.setChecked(false);

    }
}