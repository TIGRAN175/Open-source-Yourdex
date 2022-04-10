package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class NewSetInfoPage extends AppCompatActivity {
    private Button BTNmoveToSetListpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_set_info_page);


        BTNmoveToSetListpage = findViewById(R.id.Btn_MoveSetPage);         //FIND OBJECT DECLARED AND SET TO UI OBJECT

        BTNmoveToSetListpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MoveToSetListsPage();
            }
        });
    }



    public void MoveToSetListsPage()
    {
        Intent intent = new  Intent(this, CurrentSetsPage.class);
        startActivity(intent);
    }
}