package com.example.yummy;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPasswordActivity extends AppCompatActivity {
    Typeface chewy, glacial;
    TextView changePassword;
    EditText newPassword, confirmNewPassword;
    Button changeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        changePassword=findViewById(R.id.change_password);
        newPassword=findViewById(R.id.newpasswordEditText);
        confirmNewPassword=findViewById(R.id.confirmNewpasswordEditText);
        changeButton=findViewById(R.id.changeButton);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";
        this.chewy=Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);
        changePassword.setTypeface(chewy);
        newPassword.setTypeface(glacial);
        confirmNewPassword.setTypeface(glacial);
        changeButton.setTypeface(chewy);
    }

}
