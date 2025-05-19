package com.empresa.excusas.model.clases.excusas;

import com.empresa.excusas.model.clasesAbstractas.TipoExcusa;

public class ExcusaCompleja extends TipoExcusa {

    @Override
    public String getDescripcion() {
        return "Excusa Compleja";
    }

    @Override
    public boolean debeEscalar() {
        return false;
    }
}
