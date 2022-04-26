package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    SharedPreferences sp;
    String USERNAME, PASSWORD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView Username = (TextView) findViewById(R.id.SignUpUsername);  // username
        TextView Password = (TextView) findViewById(R.id.signUpPassword);  // password
        Button SignUpBTN = (Button) findViewById(R.id.signUPBTN);  // sign up button


        sp = getSharedPreferences( "MyUserpreffs", (Context.MODE_PRIVATE));



        SignUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               USERNAME = Username.getText().toString();
                PASSWORD = Password.getText().toString();
                SharedPreferences.Editor editor = sp.edit();

                editor.putString("username", USERNAME );
                editor.putString("Password", PASSWORD );

                editor.commit();

                MoveToLogin();
            }
        });
    }
    public void MoveToLogin()
    {
        Intent intent = new  Intent(this, MainActivity.class);
        startActivity(intent);
    }
}