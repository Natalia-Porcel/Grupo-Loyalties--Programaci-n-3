package com.example.yummy;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecetaActivity extends AppCompatActivity {

    Typeface chewy,glacial;
    TextView titulo,textIng,ingredientes,textPrep,preparacion;
    ImageView fotoReceta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        titulo=findViewById(R.id.NombreReceta);
        textIng=findViewById(R.id.textIngredientesReceta);
        ingredientes=findViewById(R.id.ingredientes);
        textPrep=findViewById(R.id.textPreparacionReceta);
        preparacion=findViewById(R.id.preparacion);
        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";
        this.chewy= Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        titulo.setTypeface(chewy);
        textIng.setTypeface(chewy);
        textPrep.setTypeface(chewy);
        ingredientes.setTypeface(glacial);
        preparacion.setTypeface(glacial);
    }
}
