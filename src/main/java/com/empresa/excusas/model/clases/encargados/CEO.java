package com.empresa.excusas.model.clases.encargados;

import com.empresa.excusas.interfaces.ModoOperacion;
import com.empresa.excusas.model.clases.Excusa;
import com.empresa.excusas.model.clases.excusas.ExcusaInverosimil;
import com.empresa.excusas.model.clasesAbstractas.EncargadoBase;

public class CEO extends EncargadoBase {

    public CEO(String nombre, String email, int legajo, ModoOperacion modoOperacion) {
        super(nombre, email, legajo, modoOperacion);
    }

    // Implementa el método para definir si esta clase puede manejar la excusa
    @Override
    protected boolean puedeManejar(Excusa excusa) {
        // Aquí pones la lógica para saber si la Recepcionista puede manejar esta excusa
        // Por ejemplo, maneja solo excusas triviales:
        return excusa.getTipoExcusa() instanceof ExcusaInverosimil;
    }

    // Implementa el método que procesa la excusa
    @Override
    protected void procesar(Excusa excusa) {
        // Aquí pones la lógica concreta para manejar la excusa
        System.out.println("CEO procesando excusa de tipo: " + excusa.getTipoExcusa().getDescripcion());
        // Por ejemplo, enviar un email, registrar en sistema, etc.
    }
}
