package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton BtnLogin;                      //DECLARATIONS
    @Override
    protected void onCreate(Bundle savedInstanceState) {     //UPDATE METHOD
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnLogin = findViewById(R.id.BTN_login);         //FIND OBJECT DECLARED AND SET TO UI OBJECT

        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Login clicked", Toast.LENGTH_SHORT).show();
               MoveToHomescreen();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // activity transition animation


            }
        });





    }

public void MoveToHomescreen()
{
    Intent intent = new  Intent(this, Homescreen.class);
    startActivity(intent);
}

}