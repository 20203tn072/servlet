package com.peli.peliculas.model.pelicula;

public class BeanPelicula {
    private long id;
    private String nombre;
    private String descripcion;
    private String estreno;
    private int recaudacion;
    private int status;

    public BeanPelicula() {
    }

    public BeanPelicula(long id, String nombre, String descripcion, String estreno, int recaudacion, int status) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estreno = estreno;
        this.recaudacion = recaudacion;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
