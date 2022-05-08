package com.example.yourdex;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EditText eName;           //declarations
    private EditText ePassword;
    private Button eLogin;



    boolean isValid = false;
    private int counter = 5;

    SharedPreferences sharedPreferences;         //offline finder of credentials
    SharedPreferences.Editor sharedPreferencesEditor;




//    Credentials credentials = new Credentials("Admin", "Admin");


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {     //UPDATE METHOD
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eName = findViewById(R.id.LOGIN_username);  //getting name and password
        ePassword = findViewById(R.id.LOGIN_pass);
        eLogin = findViewById(R.id.btnLogin);
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eLogin.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {

                        String inputName = eName.getText().toString();
                        String inputPassword = ePassword.getText().toString();

                        if (inputName.isEmpty() || inputPassword.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                        } else {

                            isValid = validate(inputName, inputPassword);

                            if (!isValid) {

                                counter--;

                                Toast.makeText(MainActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();


                                if (counter == 0) {
                                    eLogin.setEnabled(false);
                                }

                            } else {

                                Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                                // Add the code to go to new activity
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent);
                            }

                        }

                    }
                });


                sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);   //checking the offline "CredentialsDB" file that's now stored on the phone
                sharedPreferencesEditor = sharedPreferences.edit();

                if (sharedPreferences != null) {
                    String savedUsername = sharedPreferences.getString("Username", "");     //Getting username & password from Sign up but still thinks its an int??
                    String savedPassword = sharedPreferences.getString("Password", "");




                    //    SignUp.credentials = new Credentials(savedUsername, savedPassword);
                    SignUp.credentials = new android.net.Credentials(savedUsername, savedPassword);  //Thinks credentials here is an int but I've set it as String?

                    if (sharedPreferences.getBoolean("RememberMeCheckbox", false)) {
                        eName.setText(savedUsername);
                        ePassword.setText(savedPassword);

                    }
                }


            }


        /*
        BtnLogin = findViewById(R.id.BTN_login);         //FIND OBJECT DECLARED AND SET TO UI OBJECT
        BTN_signup = findViewById(R.id.BTN_signup);
        TextView user = (TextView) findViewById(R.id.LOGIN_username);  // username
        TextView Pass = (TextView) findViewById(R.id.LOGIN_pass);  // password
        */

/*
            // brings Username and password from sign up page to login if sign up is necessary
            SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserpreffs", Context.MODE_PRIVATE);
            String username = sp.getString("username", "");
            String pass = sp.getString("Password", "");
            */

    /*
        user.setText(username);
        Pass.setText(pass);
*/


            private boolean validate(String name, String password) {          //here if its correct

                if (SignUp.credentials != null) {
                    return name.equals(SignUp.credentials.getUsername()) && password.equals(SignUp.credentials.getPassword());
                }

                return false;
            }





/*
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
*/
        });
    }
}
