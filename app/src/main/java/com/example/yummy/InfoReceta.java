package com.example.yummy;

import java.io.Serializable;

public class InfoReceta implements Serializable {

    private String NombreReceta;
    private String Ingredientes;
    private String Preparacion;
    private int Imagen;

    public InfoReceta(String nombreReceta, String ingredientes, String preparacion, int imagen) {
        this.NombreReceta = nombreReceta;
        this.Ingredientes = ingredientes;
        this.Preparacion = preparacion;
        this.Imagen = imagen;
    }

    public InfoReceta(){

    }

    public String getNombreReceta() {
        return NombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        NombreReceta = nombreReceta;
    }

    public String getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        Ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return Preparacion;
    }

    public void setPreparacion(String preparacion) {
        Preparacion = preparacion;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
