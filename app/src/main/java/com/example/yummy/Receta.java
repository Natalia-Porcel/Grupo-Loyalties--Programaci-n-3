package com.example.yummy;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Receta implements Serializable {

    @Expose
    String nombreReceta;
    String ingredientes;
    String preparacion;
    int imagen;

    public Receta(String nombreReceta, String ingredientes, String preparacion, int imagen) {
        this.nombreReceta = nombreReceta;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.imagen = imagen;
    }

    public Receta(){

    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        preparacion = preparacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
