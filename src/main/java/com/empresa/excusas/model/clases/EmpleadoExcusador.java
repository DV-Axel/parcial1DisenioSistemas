package com.empresa.excusas.model.clases;

import com.empresa.excusas.model.clasesAbstractas.Empleado;

public class EmpleadoExcusador extends Empleado {

    public EmpleadoExcusador(String nombre, String email, int legajo) {
        super(nombre, email, legajo);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
