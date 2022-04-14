package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Homescreen extends AppCompatActivity {
    private ImageButton AddSet;
    private ImageButton GoToSets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);



        AddSet = findViewById(R.id.Btn_AddSet);         //FIND OBJECT DECLARED AND SET TO UI OBJECT
        GoToSets = findViewById(R.id.BTN_GoToSets);
        AddSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Homescreen.this, "add set clicked", Toast.LENGTH_SHORT).show();
                MoveToAddSetScreen();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);   // activity transition animation
            }
        });

        GoToSets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Homescreen.this, "moved to sets page", Toast.LENGTH_SHORT).show();
                MoveToSetsPage();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);   // activity transition animation
            }
        });



    }

    public void MoveToAddSetScreen()
    {
        Intent intent = new  Intent(this, NewSetInfoPage.class);
        startActivity(intent);
    }

    public void MoveToSetsPage()
    {
        Intent intent = new  Intent(this, CurrentSetsPage.class);
        startActivity(intent);
    }
}