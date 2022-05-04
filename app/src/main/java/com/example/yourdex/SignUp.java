package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Credentials;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    //  SharedPreferences sp;
    //   String USERNAME, PASSWORD;
    private EditText eRegName;
    private EditText eRegPassword;
    private Button eRegister;

    Credentials credentials;



    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        eRegName = findViewById(R.id.SignUpUsername);  // username
        eRegPassword = findViewById(R.id.signUpPassword);  // password
        eRegister = findViewById(R.id.signUPBTN);  // sign up button


        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();


        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String regUsername = eRegName.getText().toString();
            String regPassword = eRegPassword.getText().toString();

            if (validate(regUsername, regPassword)) {

                credentials = new Credentials(regUsername, regPassword);
                // Store credendts

                sharedPreferencesEditor.putString("Username", regUsername);
                sharedPreferencesEditor.putString("Password", regPassword);

                sharedPreferencesEditor.apply();

                startActivity(new Intent(SignUp.this, MainActivity.class));
                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        }
        });
    };




    private boolean validate (String username, String password){

        if(username.isEmpty() || password.length()< 10){
            Toast.makeText(this, "Please enter details again", Toast.LENGTH_SHORT).show();
       return false;

        }


        return false;
    };





}

