package com.example.smartdeviceappdevelopementfall2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartdeviceappdevelopementfall2019.db_access.DBConnection;

public class LoginActivity extends AppCompatActivity {

    Button loginButton;
    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginButton = findViewById(R.id.buttonLogin);
        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBConnection databaseConnection = new DBConnection(LoginActivity.this);
                boolean isChecked = databaseConnection.checkLogin(
                        usernameText.getText().toString(),
                        passwordText.getText().toString());
                if(isChecked){
                    // goto registration page
                    Intent intent =
                            new Intent(LoginActivity.this,
                                    MainActivity.class);
                    startActivity(intent);
                }else{
                    // message: username or password incorrect
                    Toast.makeText(LoginActivity.this, "Username or password incorrect!!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
