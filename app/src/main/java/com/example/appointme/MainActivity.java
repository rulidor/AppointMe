package com.example.appointme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appointme.User.UserController;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText mUsername, mPassword;
    private Button btnLogin;
    private CheckBox mCheckboxPref;
    private TextView mSignup;

    private UserController userController = new UserController();

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

                checkLoginDetails();
            }
        });

        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void checkLoginDetails() {
        if (!userController.getUserMap().keySet().contains(mUsername.getText().toString())){
            Toast.makeText(MainActivity.this, "Wrong details",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if(!userController.getUserMap().get(mUsername.getText().toString()).getPassword().equals(
                mPassword.getText().toString())) {//wrong password
            Toast.makeText(MainActivity.this, "Wrong details",
                    Toast.LENGTH_LONG).show();
            return;
        }
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