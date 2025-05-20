package com.empresa.excusas.clases.TipoExcusas;

import com.empresa.excusas.clases.tiposExcusas.ExcusaTrivial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExcusaTrivialTest {

    @Test
    public void testCreacionExcusaTrivial() {
        // Arrange
        String descripcion = "Me quedé dormido";

        // Act
        ExcusaTrivial excusa = new ExcusaTrivial(descripcion);

        // Assert
        assertEquals(descripcion, excusa.getDescripcion());
        assertTrue(excusa.toString().contains(descripcion));
    }
}