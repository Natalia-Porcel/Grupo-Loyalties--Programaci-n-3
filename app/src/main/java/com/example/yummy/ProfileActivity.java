package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView usuarios;
    Button misRecetas;
    Button likes;
    Button add;
    Typeface chewy;
    Typeface glacial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        usuarios=findViewById(R.id.textUsuario);
        misRecetas=findViewById(R.id.MisRecetas);
        likes=findViewById(R.id.likes);
        add=findViewById(R.id.ButtonAñadir);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";

        this.chewy=Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        usuarios.setTypeface(chewy);
        misRecetas.setTypeface(chewy);
        likes.setTypeface(chewy);
        add.setTypeface(chewy);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AddRecipeActivity.class);
                startActivity(intent);
            }
        });
    }
}
