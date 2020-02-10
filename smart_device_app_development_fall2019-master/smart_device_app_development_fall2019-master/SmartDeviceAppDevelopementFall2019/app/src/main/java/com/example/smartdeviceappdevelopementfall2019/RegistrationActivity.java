package com.example.smartdeviceappdevelopementfall2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartdeviceappdevelopementfall2019.db_access.DBConnection;
import com.example.smartdeviceappdevelopementfall2019.util.CommonConstant;

public class RegistrationActivity extends AppCompatActivity {

    Button backToLogin;
    EditText fullName, userName, password, emailAddress,contactNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    @Override
    protected void onStart() {
        super.onStart();
        backToLogin = findViewById(R.id.buttonRegistration);
        fullName = findViewById(R.id.fullname);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        emailAddress = findViewById(R.id.email);
        contactNumber = findViewById(R.id.phone);

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
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

    private void saveData(){

        DBConnection dbConnection = new DBConnection(this);
        dbConnection.addRegistrationData(fullName.getText().toString()
                ,userName.getText().toString()
                ,password.getText().toString()
                ,emailAddress.getText().toString(),
                contactNumber.getText().toString());
    }
}
