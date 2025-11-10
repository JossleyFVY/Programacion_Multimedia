package com.example.tareatema5_listas;

public class Peliculas {
    private String titulo;
    private String imagen;

    public Peliculas(String titulo, String imagen){

        this.titulo = titulo;
        this.imagen = imagen;
    }

    public String GetTitulo(){
        return titulo;
    }

    public String GetImagen(){
        return imagen;
    }
}
