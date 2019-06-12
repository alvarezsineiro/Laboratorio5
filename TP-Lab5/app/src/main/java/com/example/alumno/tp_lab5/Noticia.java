package com.example.alumno.tp_lab5;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Agus on 4/6/2019.
 */

public class Noticia {

    private String titulo;
    private String descripcion ="Sin descripción";
    private String ImagenUrl = "https://webhostingmedia.net/wp-content/uploads/2018/01/http-error-404-not-found.png";
    private String url;
    private byte[] imagen;
    private Date fecha;

    public Noticia() {
        fecha =new Date();
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ImagenUrl='" + ImagenUrl + '\'' +
                ", url='" + url + '\'' +
                ", Decha=" + fecha +
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
