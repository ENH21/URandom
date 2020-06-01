package com.estebannaranjo.urandom.modelo;

public class Personaje {
    private String id;
    private String Nombre;
    private String Fecha;
    private String Informacion;
    private String Categoria;

    public Personaje(String id ,String nombre, String fecha, String informacion,String categoria) {
        this.id = id;
        Nombre = nombre;
        Fecha = fecha;
        Informacion = informacion;
        Categoria = categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getInformacion() {
        return Informacion;
    }

    public void setInformacion(String informacion) {
        Informacion = informacion;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id='" + id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Fecha='" + Fecha + '\'' +
                ", Informacion='" + Informacion + '\'' +
                ", Categoria='" + Categoria + '\'' +
                '}';
    }
}
