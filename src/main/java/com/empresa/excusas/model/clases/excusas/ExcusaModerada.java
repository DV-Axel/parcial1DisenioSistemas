package com.empresa.excusas.model.clases.excusas;

import com.empresa.excusas.model.clasesAbstractas.TipoExcusa;

public class ExcusaModerada extends TipoExcusa{

    @Override
    public String getDescripcion() {
        return "Excusa Moderada";
    }

    @Override
    public boolean debeEscalar() {
        return false;
    }
}