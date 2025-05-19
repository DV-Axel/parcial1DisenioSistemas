package com.empresa.excusas.model.clasesAbstractas;

import com.empresa.excusas.interfaces.Encargado;
import com.empresa.excusas.interfaces.ModoOperacion;
import com.empresa.excusas.model.clases.Excusa;

public abstract class EncargadoBase extends Empleado implements Encargado {
    private Encargado siguiente;
    private ModoOperacion modoOperacion;

    public EncargadoBase(String nombre, String email, int legajo, ModoOperacion modoOperacion) {
        super(nombre, email, legajo);
        this.modoOperacion = modoOperacion;
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        if (puedeManejar(excusa)) {
            procesar(excusa);
        } else if (siguiente != null) {
            siguiente.manejarExcusa(excusa);
        } else {
            System.out.println("Nadie puede manejar esta excusa.");
        }
    }

    public void setModoOperacion(ModoOperacion m) {
        this.modoOperacion = m;
    }

    public ModoOperacion getModoOperacion() {
        return modoOperacion;
    }

    public void setSiguienteEncargado(Encargado e) {
        this.siguiente = e;
    }

    public Encargado getSiguienteEncargado() {
        return siguiente;
    }

    protected abstract void procesar(Excusa excusa);
    protected abstract boolean puedeManejar(Excusa excusa);

}