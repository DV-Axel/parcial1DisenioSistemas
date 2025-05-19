package com.empresa.excusas.model.clasesAbstractas;

import com.empresa.excusas.interfaces.IEmpleado;

public abstract class Empleado implements IEmpleado {
    private String nombre;
    private String email;
    private int legajo;

    public Empleado() {}

    public Empleado(String nombre, String email, int legajo) {
        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getLegajo() {
        return legajo;
    }

    @Override
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", legajo=" + legajo +
                '}';
    }
}
