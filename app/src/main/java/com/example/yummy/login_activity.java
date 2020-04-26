package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class login_activity extends AppCompatActivity {

    Button loginButton;
    EditText editTextUsername;
    EditText editTextPassword;
    ProgressBar progressBar;
    TextView forgot_password;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        loginButton=findViewById(R.id.loginButton);
        editTextUsername=findViewById(R.id.usernameEditText);
        editTextPassword=findViewById(R.id.passwordEditText);
        progressBar=findViewById(R.id.progressCircular);
        forgot_password=findViewById(R.id.forgot_password);
        register=findViewById(R.id.register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

            }
        });
    }
}
