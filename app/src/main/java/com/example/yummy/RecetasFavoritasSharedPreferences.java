package com.example.yummy;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RecetasFavoritasSharedPreferences {
    private Context context;

    public RecetasFavoritasSharedPreferences(Context context) {
        this.context = context;
    }


    public void addToFav(Receta receta) {
        ArrayList<Receta> currentRecetas = getReceta();
        currentRecetas.add(receta);
        writeToSharedPreferences(currentRecetas);
        Toast.makeText(context, "Receta añadida a favoritos", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Receta> getReceta() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Favoritos", Context.MODE_PRIVATE);
        String recetasString = sharedPreferences.getString("recetas", "[]");

        // Simple
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Receta>>() {
        }.getType();
        ArrayList<Receta> recetas = gson.fromJson(recetasString, listType);

        return recetas;
    }

    public void deleteFromCart(Receta receta) {
        ArrayList<Receta> products = getReceta();
        int position = -1;
        for (int i = 0; i < products.size(); i++) {
            if(receta.nombreReceta.equals(products.get(i).nombreReceta)) {
                position = i;
                break;
            }
        }
        if(position > -1) {
            products.remove(position);
        }

        writeToSharedPreferences(products);
        Toast.makeText(context, "Receta eliminada de favoritos", Toast.LENGTH_SHORT).show();
    }

    public void deleteAll() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("recetas");
        editor.apply();
    }

    public void writeToSharedPreferences(ArrayList<Receta> receta) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Simple
        Gson gson = new Gson();
        String productString = gson.toJson(receta);

        editor.putString("recetas", productString);
        editor.apply();
    }
}
