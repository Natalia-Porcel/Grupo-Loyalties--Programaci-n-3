package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class RegistroActivity extends AppCompatActivity {

    TextView registro;
    Typeface chewy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        registro=findViewById(R.id.textRegistro);

        String font1 = "fuentes/Chewy.ttf";
        this.chewy=Typeface.createFromAsset(getAssets(),font1);

        registro.setTypeface(chewy);

    }
}
