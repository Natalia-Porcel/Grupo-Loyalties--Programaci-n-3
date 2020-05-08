package com.example.yummy;

import android.graphics.Typeface;

public class Categorias {
    String categoria;
    int imagenCategoria;

    public Categorias(String categoria, int imagenCategoria) {
        this.categoria = categoria;
        this.imagenCategoria = imagenCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getImagenCategoria() {
        return imagenCategoria;
    }
    public int getId() {
        return categoria.hashCode();
    }

    public static Categorias[] ITEMS = {
            new Categorias("Platos Fuertes", R.drawable.plato_fuerte),
            new Categorias("Acompañamientos" , R.drawable.acompaniamiento),
            new Categorias("Ensaladas", R.drawable.ensaladas),
            new Categorias("Bebidas", R.drawable.bebidas),
            new Categorias("Salsas y Aderezos", R.drawable.salas),
            new Categorias("Bocadillos", R.drawable.bocaditos),
            new Categorias("Sopas y Guisados", R.drawable.sopas),
            new Categorias("Postres", R.drawable.postres),
            new Categorias("Reposteria", R.drawable.reposteria),
            new Categorias("Desayuno", R.drawable.desyuno),
            new Categorias("Comida Boliviana", R.drawable.plato_tipico),
    };
    public static Categorias getItem(int id) {
        for (Categorias item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
