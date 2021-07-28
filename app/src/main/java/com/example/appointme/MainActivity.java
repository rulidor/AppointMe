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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private EditText mUsername, mPassword;
    private Button btnLogin;
    private CheckBox mCheckboxPref;
    private TextView mSignup;

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
            }
        });
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