package com.example.yummy;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecetasFavoritasActivity extends AppCompatActivity {

    FileManager fileManager;
    RecyclerView rvRecetas;
    RecetasFavoritasSharedPreferences recetasSharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_favoritas);

        rvRecetas = findViewById(R.id.rvLikes);

        recetasSharedPreferencesManager = new RecetasFavoritasSharedPreferences(this);
        fileManager = new FileManager(this);

        ArrayList<Receta> products = recetasSharedPreferencesManager.getReceta();
        final RecetasFavoritazAdapter adapter = new RecetasFavoritazAdapter(this, products);

        adapter.setOnLikeClickListener(new OnLikeClickListener() {
            @Override
            public void onDeleteItemClick(Receta product) {
                recetasSharedPreferencesManager.deleteFromCart(product);
                adapter.updateProducts(recetasSharedPreferencesManager.getReceta());
            }
        });

        rvRecetas.setAdapter(adapter);
        rvRecetas.setLayoutManager(new LinearLayoutManager(this));

        String productosString = fileManager.readFromFile();
        if (productosString != null) {
            Toast.makeText(this, productosString, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Archivo no existe", Toast.LENGTH_SHORT).show();
        }
    }
}
