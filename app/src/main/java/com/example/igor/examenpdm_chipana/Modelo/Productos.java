package com.example.igor.examenpdm_chipana.Modelo;

/**
 * Created by Igor on 29/04/2018.
 */

public class Productos {


    public Productos(String titulo, String precio) {
        Titulo = titulo;
        Precio = precio;
    }

    private String Titulo;
    private String Precio;

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public Productos(){

    }


    @Override
    public String toString() {
        return "Productos{" +
                "Precio='" + Precio + '\'' +
                ",Titulo='" + Titulo + '\'' +
                '}';
    }
}
