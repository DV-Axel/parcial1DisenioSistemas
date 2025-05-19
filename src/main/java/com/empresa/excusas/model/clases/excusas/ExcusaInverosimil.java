package com.empresa.excusas.model.clases.excusas;

import com.empresa.excusas.model.clasesAbstractas.TipoExcusa;

public class ExcusaInverosimil extends TipoExcusa {

    @Override
    public String getDescripcion() {
        return "Excusa Inverosimil";
    }

    @Override
    public boolean debeEscalar() {
        return false;
    }
}
