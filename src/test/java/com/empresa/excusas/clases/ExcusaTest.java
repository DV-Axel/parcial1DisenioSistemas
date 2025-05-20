package com.empresa.excusas.clases;

import com.empresa.excusas.clases.Excusa;

import com.empresa.excusas.clases.tiposExcusas.ExcusaTrivial;
import com.empresa.excusas.clasesAbstractas.Empleado;
import com.empresa.excusas.clasesAbstractas.TipoExcusa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExcusaTest {

    // Clase auxiliar anónima para Empleado para test
    static class EmpleadoDummy extends Empleado {
        public EmpleadoDummy() {
            super("Juan", "juan@mail.com", 123);
        }
    }

    @Test
    void testGetTipoExcusa() {
        Empleado emp = new EmpleadoDummy();
        TipoExcusa tipo = new ExcusaTrivial("Me quedé dormido");
        Excusa excusa = new Excusa(emp, tipo);

        assertEquals(tipo, excusa.getTipoExcusa()); // Verifica que el tipo de excusa sea el mismo que se pasó al constructor
        assertEquals("Me quedé dormido", excusa.getTipoExcusa().getDescripcion()); // Verifica que la descripción de la excusa sea correcta
    }

    @Test
    void testToString() {
        Empleado emp = new EmpleadoDummy();
        TipoExcusa tipo = new ExcusaTrivial("Perdí el colectivo");
        Excusa excusa = new Excusa(emp, tipo);

        String salida = excusa.toString();
        assertTrue(salida.contains("Perdí el colectivo"));
        assertTrue(salida.contains("Juan"));
    }
}