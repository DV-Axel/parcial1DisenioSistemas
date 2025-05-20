package com.empresa.excusas.clasesAbstractas;

import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.interfaces.Encargado;
import com.empresa.excusas.interfaces.ModoOperacion;

public abstract class EncargadoBase extends Empleado implements Encargado {
    private Encargado siguiente;
    private ModoOperacion modoOperacion;

    public EncargadoBase(String nombre, String email, int legajo, ModoOperacion modoOperacion) {
        super(nombre, email, legajo); // Llama al constructor de Empleado
        this.modoOperacion = modoOperacion;
        this.siguiente = null;
    }

    public void setModoOperacion(ModoOperacion modoOperacion) {
        this.modoOperacion = modoOperacion;
    }

    public ModoOperacion getModoOperacion() {
        return this.modoOperacion;
    }

    @Override
    public void modoOperacion() {
        if (modoOperacion != null) {
            modoOperacion.modoOperacion();
        }
    }

    @Override
    public void setSiguiente(Encargado siguiente) {
        this.siguiente = siguiente;
    }

    public Encargado getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        if (modoOperacion != null) {
            modoOperacion.manejarExcusa(this, excusa);
        } else {
            System.out.println("No hay modo de operación asignado.");
        }
    }


    // Método de fallback si el modo operativo es 'Normal' o se usa en otros modos.
    public void manejarExcusaBase(Excusa excusa) {
        if (puedeManejar(excusa)) {
            procesar(excusa);
        } else if (siguiente != null) {
            siguiente.manejarExcusa(excusa);
        } else {
            System.out.println("La excusa no puede ser manejada.");
        }
    }


    public abstract boolean puedeManejar(Excusa excusa);
    public abstract void procesar(Excusa excusa);
}

