package com.empresa.excusas.clases.modoOperacion;

import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clasesAbstractas.EncargadoBase;
import com.empresa.excusas.interfaces.ModoOperacion;

public class ModoProductivo implements ModoOperacion {

    @Override
    public void modoOperacion() {
        System.out.println("Modo PRODUCTIVO.");
    }

    @Override
    public void manejarExcusa(EncargadoBase encargado, Excusa excusa) {
        System.out.println(encargado.getNombre() + " está en modo PRODUCTIVO.");

        if (encargado.puedeManejar(excusa)) {
            System.out.println("Enviando email al CTO por la excusa: \"" + excusa.getTipoExcusa().getDescripcion() + "\"");
            encargado.procesar(excusa); // ¡ESTO FALTABA!
        } else if (encargado.getSiguiente() != null) {
            System.out.println("Enviando email al CTO por la excusa: \"" + excusa.getTipoExcusa().getDescripcion() + "\"");
            encargado.getSiguiente().manejarExcusa(excusa);
        } else {
            System.out.println("La excusa no puede ser manejada.");
        }
    }
}

