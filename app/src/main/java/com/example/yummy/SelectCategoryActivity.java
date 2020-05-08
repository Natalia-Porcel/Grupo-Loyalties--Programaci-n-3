package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class SelectCategoryActivity extends AppCompatActivity {

    TextView selectCategoria;
    Typeface chewy, glacial;
    private GridView gridView;
    private Categorias adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        selectCategoria=findViewById(R.id.textSelectCategorias);
        gridView=findViewById(R.id.gridSelectCategoria);
        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";
        this.chewy=Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);
        selectCategoria.setTypeface(chewy);

        gridView.setAdapter(new AdapterCategoria(this));
    }
}
