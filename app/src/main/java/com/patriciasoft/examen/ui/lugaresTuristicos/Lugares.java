package com.patriciasoft.examen.ui.lugaresTuristicos;

import java.io.Serializable;

public class Lugares implements Serializable {
    private String nombre;

    private String descripcion;

    public Lugares(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
}
