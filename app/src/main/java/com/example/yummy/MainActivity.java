package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button profile;
    EditText nombreReceta;
    TextView categorias;
    Typeface chewy;
    Typeface glacial;
    private GridView gridView;
    private Categorias adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile=findViewById(R.id.perfil);
        nombreReceta=findViewById(R.id.name_recipe);
        categorias=findViewById(R.id.textCategorias);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";

        this.chewy=Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);
        profile.setTypeface(chewy);
        categorias.setTypeface(chewy);
        nombreReceta.setTypeface(glacial);

        gridView = findViewById(R.id.gridCategoria);
        gridView.setAdapter(new AdapterCategoria(this));
        gridView.setOnItemClickListener(this);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent =new Intent(MainActivity.this, RecycleViewRecetas.class);
        startActivity(intent);
    }
}
