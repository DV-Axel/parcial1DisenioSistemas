package com.empresa.excusas.clases.encargados;

import com.empresa.excusas.Email;
import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clases.tiposExcusas.ExcusaTrivial;
import com.empresa.excusas.clasesAbstractas.EncargadoBase;
import com.empresa.excusas.interfaces.EmailSender;
import com.empresa.excusas.interfaces.ModoOperacion;

public class Recepcionista extends EncargadoBase {

    public Recepcionista(String nombre, String email, int legajo, ModoOperacion modoOperacion) {
        super(nombre, email, legajo, modoOperacion);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.getTipoExcusa() instanceof ExcusaTrivial;
    }

    @Override
    public void procesar(Excusa excusa) {
        System.out.println(this.getNombre() + " procesando excusa: " + excusa.getTipoExcusa().getDescripcion());
        modoOperacion(); // ejecuta estrategia actual

        EmailSender emailSender = new Email();
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Motivo demora",
                "La licencia fue aprobada"
        );
    }
}

