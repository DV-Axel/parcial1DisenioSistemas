package com.empresa.excusas.clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoExcusadorTest {

    @Test
    public void testCreacionEmpleadoExcusador() {
        EmpleadoExcusador excusador = new EmpleadoExcusador("Axel", "axel@empresa.com", 1001);

        assertEquals("Axel", excusador.getNombre());
        assertEquals("axel@empresa.com", excusador.getEmail());
        assertEquals(1001, excusador.getLegajo());
    }

}
