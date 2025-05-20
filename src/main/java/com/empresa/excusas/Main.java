package com.empresa.excusas;


import com.empresa.excusas.clases.EmpleadoExcusador;
import com.empresa.excusas.clases.Excusa;
import com.empresa.excusas.clases.encargados.CEO;
import com.empresa.excusas.clases.encargados.GerenteRRHH;
import com.empresa.excusas.clases.encargados.Recepcionista;
import com.empresa.excusas.clases.encargados.SupervisorArea;
import com.empresa.excusas.clases.modoOperacion.ModoNormal;
import com.empresa.excusas.clases.modoOperacion.ModoProductivo;
import com.empresa.excusas.clases.modoOperacion.ModoVago;
import com.empresa.excusas.clases.tiposExcusas.ExcusaCompleja;
import com.empresa.excusas.clases.tiposExcusas.ExcusaInverosimil;
import com.empresa.excusas.clases.tiposExcusas.ExcusaModerada;
import com.empresa.excusas.clases.tiposExcusas.ExcusaTrivial;
import com.empresa.excusas.clasesAbstractas.Empleado;
import com.empresa.excusas.interfaces.Encargado;
import com.empresa.excusas.interfaces.ModoOperacion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Modo de operación
        ModoOperacion vago = new ModoVago();
        ModoOperacion productivo = new ModoProductivo();
        ModoOperacion normal = new ModoNormal();

        // Encargados con diferentes modos
        Encargado recepcionista = new Recepcionista("Luis", "luis@empresa.com", 100, normal);
        Encargado supervisor = new SupervisorArea("Marta", "marta@empresa.com", 101, normal);
        Encargado gerenteRRHH = new GerenteRRHH("Sofía", "sofia@empresa.com", 102, normal);
        Encargado ceo = new CEO("Lucía", "lucia@empresa.com", 104, productivo);

        // Cadena de responsabilidad
        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerenteRRHH);
        gerenteRRHH.setSiguiente(ceo);


        // Empleado que presenta las excusas
        EmpleadoExcusador empleado = new EmpleadoExcusador("Juan", "juan@empresa.com", 1) {};

        // Crear excusas
        Excusa excusa1 = new Excusa(empleado, new ExcusaTrivial("Llegué tarde porque perdí el bondi"));
        Excusa excusa2 = new Excusa(empleado, new ExcusaModerada("Me dormí y perdí una reunión"));
        Excusa excusa3 = new Excusa(empleado, new ExcusaCompleja("No entregué el informe a tiempo"));
        Excusa excusa4 = new Excusa(empleado, new ExcusaInverosimil("Filtré información confidencial"));

        // Probar excusas
        System.out.println("\n=== Excusa Trivial ===");
        recepcionista.manejarExcusa(excusa3);



    }
}