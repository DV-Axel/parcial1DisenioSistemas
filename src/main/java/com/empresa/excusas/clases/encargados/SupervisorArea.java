package com.empresa.excusas.clases.encargados;

import com.empresa.excusas.Email;
import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clases.tiposExcusas.ExcusaModerada;
import com.empresa.excusas.clases.tiposExcusas.ExcusaTrivial;
import com.empresa.excusas.clasesAbstractas.EncargadoBase;
import com.empresa.excusas.interfaces.EmailSender;
import com.empresa.excusas.interfaces.ModoOperacion;

public class SupervisorArea extends EncargadoBase {

    public SupervisorArea(String nombre, String email, int legajo, ModoOperacion modoOperacion) {
        super(nombre, email, legajo, modoOperacion);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.getTipoExcusa() instanceof ExcusaModerada;
    }

    @Override
    public void procesar(Excusa excusa) {
        System.out.println(this.getNombre() + " procesando excusa: " + excusa.getTipoExcusa().getDescripcion());
        modoOperacion(); // ejecuta estrategia actual

        EmailSender emailSender = new Email();
        String motivoExcusa = excusa.getTipoExcusa().getDescripcion().toLowerCase();

        if(motivoExcusa.contains("cort") && motivoExcusa.contains("luz")){
            emailSender.enviarEmail(
                    "edesur@mailfake.com.ar",
                    this.getEmail(),
                    "Consulta por corte de luz",
                    "Se consulta si hubo corte de luz"
            );
        }else if(motivoExcusa.contains("cuidar") && motivoExcusa.contains("familiar")){
            emailSender.enviarEmail(
                    excusa.getEmpleado().getEmail(),
                    this.getEmail(),
                    "Esperamos que esté todo bien",
                    "El equipo de RRHH está para acompañarte."
            );
        }
    }
}