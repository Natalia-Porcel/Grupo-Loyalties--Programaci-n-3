package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class AddRecipeActivity extends AppCompatActivity {
    TextView nombreReceta,TextIngredientes,TextPreparacion,addFoto;
    EditText ingredientes,pasos;
    Button añadirACategoria;
    ImageButton camara,galeria;
    ImageView fotoReceta;
    Typeface chewy,glacial;
    Uri imageUri;

    static int REQUEST_CAMERA = 1234;
    static int REQUEST_GALLERY = 2468;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        nombreReceta=findViewById(R.id.receta);
        TextIngredientes=findViewById(R.id.textIngredientes);
        TextPreparacion=findViewById(R.id.Textpreparacion);
        ingredientes=findViewById(R.id.ingredientesEditText);
        pasos=findViewById(R.id.pasosEditText);
        addFoto=findViewById(R.id.añadeImage);
        añadirACategoria=findViewById(R.id.BUTTON);
        camara=findViewById(R.id.cameraButton);
        galeria=findViewById(R.id.galleryButton);
        fotoReceta=findViewById(R.id.fotoDeReceta);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";

        this.chewy= Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        nombreReceta.setTypeface(chewy);
        TextIngredientes.setTypeface(chewy);
        TextPreparacion.setTypeface(chewy);
        ingredientes.setTypeface(glacial);
        pasos.setTypeface(glacial);
        addFoto.setTypeface(chewy);
        añadirACategoria.setTypeface(chewy);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        });

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen:"), REQUEST_GALLERY);
            }
        });
        añadirACategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddRecipeActivity.this,SelectCategoryActivity.class);
                startActivity(intent);
                Context context = getApplicationContext();
                Toast.makeText(context, "Seleccione la categoria de la receta",Toast.LENGTH_SHORT);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            fotoReceta.setImageURI(imageUri);
        }
        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            fotoReceta.setImageURI(data.getData());
        }
    }
}
