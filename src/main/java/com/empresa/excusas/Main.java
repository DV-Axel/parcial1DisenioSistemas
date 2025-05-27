package com.empresa.excusas;


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
        Encargado recepcionista2 = new Recepcionista("Marcos", "marcos@empresa.com", 132, normal);
        Encargado recepcionista3 = new Recepcionista("Eduardo", "eduardo@empresa.com", 989, normal);

        Encargado supervisor = new SupervisorArea("Marta", "marta@empresa.com", 101, productivo);

        Encargado gerenteRRHH = new GerenteRRHH("Sofía", "sofia@empresa.com", 102, vago);
        Encargado gerenteRRHH2 = new GerenteRRHH("Hernan", "hernan@empresa.com", 333, vago);
        Encargado gerenteRRHH3 = new GerenteRRHH("Mario", "mario@empresa.com", 222, vago);
        Encargado gerenteRRHH4 = new GerenteRRHH("Guillermo", "guillermo@empresa.com", 534, vago);

        Encargado ceo = new CEO("Lucía", "lucia@empresa.com", 178, vago);
        Encargado ceo2 = new CEO("Maria", "maria@empresa.com", 999, vago);
        Encargado ceo3 = new CEO("Carlos", "carlos@empresa.com", 352, vago);

        // Cadena de responsabilidad

        recepcionista.setSiguiente(gerenteRRHH);
        gerenteRRHH.setSiguiente(gerenteRRHH2);
        gerenteRRHH2.setSiguiente(supervisor);
        supervisor.setSiguiente(recepcionista2);
        recepcionista2.setSiguiente(ceo);
        ceo.setSiguiente(ceo2);
        ceo2.setSiguiente(gerenteRRHH3);
        gerenteRRHH3.setSiguiente(recepcionista3);
        recepcionista3.setSiguiente(gerenteRRHH4);
        gerenteRRHH4.setSiguiente(ceo3);



        // Empleado que presenta las excusas
        Empleado empleado = new Empleado("Juan", "juan@empresa.com", 1) {};

        // Crear excusas
        Excusa trivial = new Excusa(empleado, new ExcusaTrivial("Llegué tarde porque perdí el bondi"));
        Excusa moderada = new Excusa(empleado, new ExcusaModerada("se cortó la luz en todo el barrio"));
        Excusa compleja = new Excusa(empleado, new ExcusaCompleja("Una paloma robó mi bicicleta"));
        Excusa inverosimil = new Excusa(empleado, new ExcusaInverosimil("El caballo de mi abuela se escapo y me mordió"));

        // Probar excusas

        System.out.println("\n=== Excusa moderada ===");
        recepcionista.manejarExcusa(moderada);

        //System.out.println("\n=== Excusa Moderada ===");
        //recepcionista.manejarExcusa(excusa2);

        //System.out.println("\n=== Excusa Compleja ===");
        //recepcionista.manejarExcusa(excusa3);

        //System.out.println("\n=== Excusa Inverosimil ===");
        //recepcionista.manejarExcusa(excusa4);

    }
}