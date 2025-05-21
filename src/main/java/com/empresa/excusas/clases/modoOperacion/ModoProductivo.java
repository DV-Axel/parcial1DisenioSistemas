package com.empresa.excusas.clases.modoOperacion;

import com.empresa.excusas.clases.Email;
import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clasesAbstractas.EncargadoBase;
import com.empresa.excusas.interfaces.EmailSender;
import com.empresa.excusas.interfaces.ModoOperacion;

public class ModoProductivo implements ModoOperacion {

    @Override
    public void modoOperacion() {
        System.out.println("Modo PRODUCTIVO.");
    }

    @Override
    public void manejarExcusa(EncargadoBase encargado, Excusa excusa) {

        enviarEmailAlCTO(encargado, excusa);

        if (encargado.puedeManejar(excusa)) {
            encargado.procesar(excusa); // ¡ESTO FALTABA!
        } else if (encargado.getSiguiente() != null) {
            encargado.getSiguiente().manejarExcusa(excusa);
        } else {
            System.out.println("La excusa no puede ser manejada.");
        }
    }

    private void enviarEmailAlCTO(EncargadoBase encargado, Excusa excusa) {
        EmailSender emailSender = new Email();
        emailSender.enviarEmail(
                "CTO",
                encargado.getEmail(),
                "Excusa recibida",
                "Se ha recibido una excusa de " + excusa.getEmpleado().getNombre() + " con el motivo: " + excusa.getTipoExcusa().getDescripcion()
        );
    }
}

