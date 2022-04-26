package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton BtnLogin;                      //DECLARATIONS
    private Button BTN_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {     //UPDATE METHOD
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnLogin = findViewById(R.id.BTN_login);         //FIND OBJECT DECLARED AND SET TO UI OBJECT
        BTN_signup = findViewById(R.id.BTN_signup);
        TextView user = (TextView) findViewById(R.id.LOGIN_username);  // username
        TextView Pass = (TextView) findViewById(R.id.LOGIN_pass);  // password




        // brings Username and password from sign up page to login if sign up is nessisary
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserpreffs", Context.MODE_PRIVATE);
        String usename = sp.getString("username", "");
        String pass = sp.getString("Password", "");

        user.setText(usename);
        Pass.setText(pass);

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login clicked", Toast.LENGTH_SHORT).show();
               MoveToHomescreen();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // activity transition animation


            }
        });


        BTN_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoveToSIgnUp();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // activity transition animation


            }
        });




    }

public void MoveToHomescreen()
{
    Intent intent = new  Intent(this, Homescreen.class);
    startActivity(intent);
}

    public void MoveToSIgnUp()
    {
        Intent intent = new  Intent(this, SignUp.class);
        startActivity(intent);
    }

}