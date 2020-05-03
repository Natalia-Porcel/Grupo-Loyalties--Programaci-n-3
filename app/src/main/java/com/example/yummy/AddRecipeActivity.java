package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddRecipeActivity extends AppCompatActivity {
    TextView nombreReceta;
    TextView TextIngredientes;
    TextView TextPreparacion;
    EditText ingredientes;
    EditText pasos;
    Button foto;
    Button añadirACategoria;
    Typeface chewy;
    Typeface glacial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        nombreReceta=findViewById(R.id.receta);
        TextIngredientes=findViewById(R.id.textIngredientes);
        TextPreparacion=findViewById(R.id.Textpreparacion);
        ingredientes=findViewById(R.id.ingredientesEditText);
        pasos=findViewById(R.id.pasosEditText);
        foto=findViewById(R.id.añadirFoto);
        añadirACategoria=findViewById(R.id.BUTTON);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";

        this.chewy= Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        nombreReceta.setTypeface(chewy);
        TextIngredientes.setTypeface(chewy);
        TextPreparacion.setTypeface(chewy);
        ingredientes.setTypeface(glacial);
        pasos.setTypeface(glacial);
        foto.setTypeface(chewy);
        añadirACategoria.setTypeface(chewy);


    }

}
