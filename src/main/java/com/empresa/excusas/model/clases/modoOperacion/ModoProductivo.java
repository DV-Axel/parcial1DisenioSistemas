package com.empresa.excusas.model.clases.modoOperacion;

import com.empresa.excusas.interfaces.ModoOperacion;

public class ModoProductivo implements ModoOperacion {

    public void modoOperacion() {
        System.out.println("Modo Productivo activado");
    }
}
