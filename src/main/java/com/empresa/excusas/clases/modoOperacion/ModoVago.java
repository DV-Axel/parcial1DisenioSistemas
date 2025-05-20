package com.empresa.excusas.clases.modoOperacion;

import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clasesAbstractas.EncargadoBase;
import com.empresa.excusas.interfaces.ModoOperacion;

public class ModoVago implements ModoOperacion {

    @Override
    public void modoOperacion() {
        System.out.println("Modo: Vago");
    }

    @Override
    public void manejarExcusa(EncargadoBase encargado, Excusa excusa) {
        System.out.println(encargado.getNombre() + " está en modo VAGO. No hace nada y delega.");

        if (encargado.getSiguiente() != null) {
            encargado.getSiguiente().manejarExcusa(excusa);
        } else {
            System.out.println("Nadie más puede manejar la excusa.");
        }
    }
}

