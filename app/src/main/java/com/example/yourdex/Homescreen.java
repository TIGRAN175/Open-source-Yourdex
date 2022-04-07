package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Homescreen extends AppCompatActivity {
    private ImageButton AddSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);



        AddSet = findViewById(R.id.Btn_AddSet);         //FIND OBJECT DECLARED AND SET TO UI OBJECT

        AddSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Homescreen.this, "add set clicked", Toast.LENGTH_SHORT).show();
                MoveToAddSetScreen();
            }
        });




    }

    public void MoveToAddSetScreen()
    {
        Intent intent = new  Intent(this, NewSetInfoPage.class);
        startActivity(intent);
    }
}