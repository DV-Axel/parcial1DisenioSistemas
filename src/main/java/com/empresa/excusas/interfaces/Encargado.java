package com.empresa.excusas.interfaces;

import com.empresa.excusas.model.clases.Excusa;

public interface Encargado {
    ModoOperacion getModoOperacion();
    void setModoOperacion(ModoOperacion modoOperacion);

    Encargado getSiguienteEncargado();
    void setSiguienteEncargado(Encargado encargado);

    void manejarExcusa(Excusa excusa); // Asumiendo que existe la clase Excusa
}