package com.example.yummy;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText editTextPassword;
    EditText editTextUsername;
    ProgressBar circularBar;
    ProgressBar horizontal;
    TextView forgotPassword;
    TextView register;
    CheckBox remember;
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
        remember=findViewById(R.id.cbRememberMe);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";

        this.chewy= Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        loginButton.setTypeface(chewy);
        editTextUsername.setTypeface(glacial);
        editTextPassword.setTypeface(glacial);
        forgotPassword.setTypeface(glacial);
        register.setTypeface(glacial);
        remember.setTypeface(glacial);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                circularBar.setVisibility(View.VISIBLE);
                final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Usuario user = new Usuario(editTextUsername.getText().toString(), editTextPassword.getText().toString());
                intent.putExtra("user", user);
                if (remember.isChecked()) {
                    guardarPreferencias();
                } else {

                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivityForResult(intent,numer);
                    }
                }, 2000);
                animarProgressBar();
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginActivity.this,ForgetPasswordActivity.class);
                startActivity(intent);
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

        cargarPreferencias();

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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginButton:
                guardarPreferencias();
                break;
        }
    }

    private  void  cargarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("nombre", MODE_PRIVATE);
        String usuario= preferencias.getString("usuario","");
        String pass=preferencias.getString("pass","");
        editTextUsername.setText(usuario);
        editTextPassword.setText(pass);
    }

    private void guardarPreferencias() {
        SharedPreferences preferencias = getSharedPreferences("nombre", MODE_PRIVATE);
        String usuario= editTextPassword.getText().toString();
        String pass= editTextPassword.getText().toString();
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("user",usuario);
        editor.putString("pass",pass);
        editTextUsername.setText(usuario);
        editTextPassword.setText(pass);
        editor.commit();
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

