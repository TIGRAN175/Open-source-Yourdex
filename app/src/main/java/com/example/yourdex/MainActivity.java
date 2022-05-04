package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Credentials;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton BtnLogin;                      //DECLARATIONS
    private Button BTN_signup;


    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eRegister;

    private String Username = "Admin";
    private String Password = "12345678";




    boolean isValid = false;
    private int counter = 5;

    SharedPreferences sharedPreferences;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {     //UPDATE METHOD
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.LOGIN_username);
        ePassword = findViewById(R.id.LOGIN_pass);
        eLogin = findViewById(R.id.btnLogin);

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);


           if(sharedPreferences != null)
           {
               String savedUsername = sharedPreferences.getString("Username","");
               String savedPassword = sharedPreferences.getString("Password","");

           //    SignUp.credentials = new Credentials(savedUsername, savedPassword);



           }


        /*
        BtnLogin = findViewById(R.id.BTN_login);         //FIND OBJECT DECLARED AND SET TO UI OBJECT
        BTN_signup = findViewById(R.id.BTN_signup);
        TextView user = (TextView) findViewById(R.id.LOGIN_username);  // username
        TextView Pass = (TextView) findViewById(R.id.LOGIN_pass);  // password
        */



        // brings Username and password from sign up page to login if sign up is nessisary
        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserpreffs", Context.MODE_PRIVATE);
        String usename = sp.getString("username", "");
        String pass = sp.getString("Password", "");
    /*
        user.setText(usename);
        Pass.setText(pass);
*/


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();



                if(inputName.isEmpty() || inputPassword.isEmpty()){

                    //If nothing is entered
                }


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
    private boolean validate(String name, String password){
        if(name.equals(Username)&& password.equals(Password)){
    return true;
        }
    return  false;

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