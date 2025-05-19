package com.empresa.excusas;

import com.empresa.excusas.interfaces.ModoOperacion;
import com.empresa.excusas.model.clases.EmpleadoExcusador;
import com.empresa.excusas.model.clases.Excusa;
import com.empresa.excusas.model.clases.encargados.Recepcionista;
import com.empresa.excusas.model.clases.excusas.ExcusaCompleja;
import com.empresa.excusas.model.clases.excusas.ExcusaInverosimil;
import com.empresa.excusas.model.clases.excusas.ExcusaModerada;
import com.empresa.excusas.model.clases.excusas.ExcusaTrivial;
import com.empresa.excusas.model.clases.modoOperacion.ModoNormal;
import com.empresa.excusas.model.clasesAbstractas.Empleado;
import com.empresa.excusas.model.clasesAbstractas.TipoExcusa;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TipoExcusa trivial = new ExcusaTrivial();
        TipoExcusa inverosimil = new ExcusaInverosimil();
        TipoExcusa compleja = new ExcusaCompleja();
        TipoExcusa moderada = new ExcusaModerada();


        EmpleadoExcusador emp = new EmpleadoExcusador("Axel Cichello", "csaxel49@gmail.com", 40143488);

        Excusa excusa1 = new Excusa("Me quede dormido", trivial, emp);
        Excusa excusa2 = new Excusa("Me quede dormido", inverosimil, emp);
        Excusa excusa3 = new Excusa("Me quede dormido", compleja, emp);
        Excusa excusa4 = new Excusa("Me quede dormido", moderada, emp);

        ModoOperacion modoNormal = new ModoNormal();

        Recepcionista recep = new Recepcionista("Recepcionista", "recepcionista@rec.com", 123456, modoNormal);


        System.out.println(emp.toString());
        //System.out.println(excusa1.getTipoExcusa().getClass().getSimpleName());  para saber a que instancia pertenece

    }
}