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
        Encargado recepcionista = new Recepcionista("Luis", "luis@empresa.com", 100, vago);
        Encargado recepcionista2 = new Recepcionista("Marcos", "marcos@empresa.com", 100, normal);
        Encargado supervisor = new SupervisorArea("Marta", "marta@empresa.com", 101, normal);
        Encargado gerenteRRHH = new GerenteRRHH("Sofía", "sofia@empresa.com", 102, normal);
        Encargado ceo = new CEO("Lucía", "lucia@empresa.com", 104, normal);

        // Cadena de responsabilidad
        recepcionista.setSiguiente(recepcionista2);
        recepcionista2.setSiguiente(supervisor);
        supervisor.setSiguiente(gerenteRRHH);
        gerenteRRHH.setSiguiente(ceo);


        // Empleado que presenta las excusas
        EmpleadoExcusador empleado = new EmpleadoExcusador("Juan", "juan@empresa.com", 1) {};

        // Crear excusas
        Excusa excusa1 = new Excusa(empleado, new ExcusaTrivial("Llegué tarde porque perdí el bondi"));
        Excusa excusa2 = new Excusa(empleado, new ExcusaModerada("Tuve que cuidar a un familiar"));
        Excusa excusa3 = new Excusa(empleado, new ExcusaCompleja("Una paloma robó mi bicicleta"));
        Excusa excusa4 = new Excusa(empleado, new ExcusaInverosimil("El caballo de mi abuela se escapo y me mordió"));

        // Probar excusas
        System.out.println("\n=== Excusa Trivial ===");
        recepcionista.manejarExcusa(excusa1);

        //System.out.println("\n=== Excusa Moderada ===");
        //recepcionista.manejarExcusa(excusa2);

        //System.out.println("\n=== Excusa Compleja ===");
        //recepcionista.manejarExcusa(excusa3);

        //System.out.println("\n=== Excusa Inverosimil ===");
        //recepcionista.manejarExcusa(excusa4);

    }
}