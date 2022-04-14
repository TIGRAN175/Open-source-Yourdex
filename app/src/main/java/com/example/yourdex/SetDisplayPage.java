package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SetDisplayPage extends AppCompatActivity {
    private ImageButton Btnaddcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_display_page);



        Btnaddcard = findViewById(R.id.IMG_BTN_AddCardToSet);         //FIND OBJECT DECLARED AND SET TO UI OBJECT

        Btnaddcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MoveToAddCardScreen();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // activity transition animation


            }
        });



    }

    public void MoveToAddCardScreen()
    {
        Intent intent = new  Intent(this, NewItemToAddInfoPage.class);
        startActivity(intent);
    }
}