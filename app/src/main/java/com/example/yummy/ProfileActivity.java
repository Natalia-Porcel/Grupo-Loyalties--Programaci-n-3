package com.example.yummy;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    TextView usuarios;
    Button misRecetas;
    Button likes,add,logout;
    Typeface chewy;
    Typeface glacial;
    UsuarioSharedPreferencesManager usuarioPreferencias;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        usuarios=findViewById(R.id.textUsuario);
        misRecetas=findViewById(R.id.MisRecetas);
        likes=findViewById(R.id.likes);
        add=findViewById(R.id.ButtonAñadir);
        logout=findViewById(R.id.ButtonCerrarSesion);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";

        this.chewy=Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        usuarios.setTypeface(chewy);
        misRecetas.setTypeface(chewy);
        likes.setTypeface(chewy);
        add.setTypeface(chewy);
        logout.setTypeface(chewy);

        usuarioPreferencias = new UsuarioSharedPreferencesManager(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, AddRecipeActivity.class);
                startActivity(intent);
            }
        });

        likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (ProfileActivity.this, RecetasFavoritasActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

    }
    private void logOut(){
        Intent intent =new Intent (this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
