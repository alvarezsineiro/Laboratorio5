package com.example.alumno.primerparcial;

/**
 * Created by alumno on 09/05/2019.
 */

public class Producto {
    private String id;
    private String nombre;
    private String precio;
    private int cantidad;

    public Producto(String id, String nombre, String precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", precio='" + precio + '\'' +
                '}';
    }
}
