package com.example.yummy;

import com.google.gson.annotations.Expose;

public class Receta {
    @Expose
    String nombreReceta;

    public Receta(String name, int image, int price) {
        this.nombreReceta = name;
    }
    public String getName() {
        return nombreReceta;
    }

    public void setName(String name) {
        this.nombreReceta = name;
    }


}
