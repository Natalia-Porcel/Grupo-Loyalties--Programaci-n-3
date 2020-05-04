package com.example.yummy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText editTextPassword;
    EditText editTextUsername;
    ProgressBar circularBar;
    ProgressBar horizontal;
    TextView forgotPassword;
    TextView register;
    Typeface chewy;
    Typeface glacial;

    int numer=1;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton=findViewById(R.id.loginButton);
        editTextPassword=findViewById(R.id.passwordEditText);
        editTextUsername=findViewById(R.id.usernameEditText);
        circularBar=findViewById(R.id.circular);
        forgotPassword=findViewById(R.id.forgot_password);
        register=findViewById(R.id.newRegister);
        horizontal=findViewById(R.id.progreso);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";

        this.chewy= Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        loginButton.setTypeface(chewy);
        editTextUsername.setTypeface(glacial);
        editTextPassword.setTypeface(glacial);
        forgotPassword.setTypeface(glacial);
        register.setTypeface(glacial);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                circularBar.setVisibility(View.VISIBLE);
                final Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivityForResult(intent,numer);
                    }
                }, 2000);
                animarProgressBar();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro=new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(registro);
            }
        });

        editTextUsername.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId== EditorInfo.IME_ACTION_NEXT){
                    Log.d("TEST", "KEYBOARD DONE");
                }
                return false;
            }
        });

        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int action, KeyEvent keyEvent) {
                if (action == EditorInfo.IME_ACTION_DONE) {
                    Log.d("TEST", "KEYBOARD DONE");
                }
                return false;
            }
        });

    }
    private void animarProgressBar(){
        ValueAnimator valueAnimator= new ValueAnimator();
        valueAnimator.setIntValues(0 , 100);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                horizontal.setProgress((int)animation.getAnimatedValue());
            }
        });
        valueAnimator.start();
    }
    @Override
    protected void onStart() {
        super.onStart();
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
    protected void onRestart() {
        super.onRestart();
        circularBar.setVisibility(View.INVISIBLE);
        horizontal.setProgress(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

