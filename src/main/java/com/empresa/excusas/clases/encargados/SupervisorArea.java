package com.empresa.excusas.clases.encargados;

import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clases.tiposExcusas.ExcusaModerada;
import com.empresa.excusas.clases.tiposExcusas.ExcusaTrivial;
import com.empresa.excusas.clasesAbstractas.EncargadoBase;
import com.empresa.excusas.interfaces.ModoOperacion;

public class SupervisorArea extends EncargadoBase {

    public SupervisorArea(String nombre, String email, int legajo, ModoOperacion modoOperacion) {
        super(nombre, email, legajo, modoOperacion);
    }

    @Override
    protected boolean puedeManejar(Excusa excusa) {
        return excusa.getTipoExcusa() instanceof ExcusaModerada;
    }

    @Override
    protected void procesar(Excusa excusa) {
        System.out.println("SupervisorArea procesando excusa: " + excusa.getTipoExcusa().getDescripcion());
        modoOperacion(); // ejecuta estrategia actual
    }
}