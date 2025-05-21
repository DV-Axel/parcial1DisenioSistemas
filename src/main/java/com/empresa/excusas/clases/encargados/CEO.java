package com.empresa.excusas.clases.encargados;

import com.empresa.excusas.clases.AdministradorProntuarios;
import com.empresa.excusas.clases.Email;
import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clases.Prontuario;
import com.empresa.excusas.clases.tiposExcusas.ExcusaInverosimil;
import com.empresa.excusas.clasesAbstractas.EncargadoBase;
import com.empresa.excusas.interfaces.EmailSender;
import com.empresa.excusas.interfaces.ModoOperacion;
import com.empresa.excusas.interfaces.ObserverProntuario;


public class CEO extends EncargadoBase implements ObserverProntuario {

    public CEO(String nombre, String email, int legajo, ModoOperacion modoOperacion) {
        super(nombre, email, legajo, modoOperacion);
        AdministradorProntuarios.getInstancia().agregarObserver(this); // se registra para recibir notificaciones

    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.getTipoExcusa() instanceof ExcusaInverosimil;
    }

    @Override
    public void procesar(Excusa excusa) {
        System.out.println(this.getNombre()+ " procesando excusa: " + excusa.getTipoExcusa().getDescripcion());
        modoOperacion(); // ejecuta estrategia actual

        EmailSender emailSender = new Email();
        emailSender.enviarEmail(
                excusa.getEmpleado().getEmail(),
                this.getEmail(),
                "Motivo demora",
                "Aprobado por creatividad"
        );

        // crea prontuario y lo agrega
        Prontuario prontuario = new Prontuario(
                excusa.getEmpleado().getNombre(),
                excusa.getEmpleado().getEmail(),
                excusa.getEmpleado().getLegajo(),
                excusa
        );
        AdministradorProntuarios.getInstancia().agregarProntuario(prontuario);

        System.out.println(AdministradorProntuarios.getInstancia().getProntuarios());

    }

    @Override
    public void actualizar(Prontuario prontuario) {
        if (!prontuario.getEmailEmpleado().equals(this.getEmail())) {
            // Notificar a CEO sobre nuevo prontuario generado (no se notifica a sí mismo)
            EmailSender emailSender = new Email();
            emailSender.enviarEmail(
                    this.getEmail(),
                    "sistema@empresa.com",
                    "Nuevo prontuario generado",
                    "Se ha generado un nuevo prontuario para el empleado: " + prontuario.getNombreEmpleado()
            );
        }
    }
}