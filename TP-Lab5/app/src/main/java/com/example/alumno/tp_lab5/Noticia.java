package com.example.alumno.tp_lab5;

import java.util.Arrays;

/**
 * Created by Agus on 4/6/2019.
 */

public class Noticia {

    private String titulo;
    private String descripcion;
    private String ImagenUrl;
    private String url;
    private byte[] imagen;

    public Noticia() {
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ImagenUrl='" + ImagenUrl + '\'' +
                ", url='" + url + '\'' +
                ", imagen=" + Arrays.toString(imagen) +
                '}';
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenUrl(String imagenUrl) {
        ImagenUrl = imagenUrl;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagenUrl() {
        return ImagenUrl;
    }

    public String getUrl() {
        return url;
    }

    public byte[] getImagen() {
        return imagen;
    }
}
