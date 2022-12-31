package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // Declare UI elements

    EditText password, Email;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements

        password = findViewById(R.id.password);
        Email = findViewById(R.id.Email);
        button1=(Button) findViewById(R.id.button);


        // Set up click listener for login button

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set up the condition when the email and password are not enter, it will show the error message

                if (Email.getText().toString().isEmpty() || !Email.getText().toString().contains("@")) {
                    Email.setError("Enter your email!");
                    Toast.makeText(MainActivity.this, "Invalid username or password",Toast.LENGTH_LONG).show();
                }  else if (password.getText().toString().length() < 8 ){
                    password.setError("Enter your password!");
                    Toast.makeText(MainActivity.this, "Invalid username or password",Toast.LENGTH_LONG).show();;
                }  else {

                    // If email and password are correct,  login is successful and open employee home

                    Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent); }
                }
        });
    }
}