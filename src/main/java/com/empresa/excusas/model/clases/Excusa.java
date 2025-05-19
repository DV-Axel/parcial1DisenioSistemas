package com.empresa.excusas.model.clases;

import com.empresa.excusas.model.clasesAbstractas.Empleado;
import com.empresa.excusas.model.clasesAbstractas.TipoExcusa;

public class Excusa {
    private String motivo;
    private TipoExcusa tipoExcusa;
    private Empleado empleado;

    public Excusa() {}

    public Excusa(String motivo, TipoExcusa tipoExcusa, Empleado empleado) {
        this.motivo = motivo;
        this.tipoExcusa = tipoExcusa;
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoExcusa getTipoExcusa() {
        return tipoExcusa;
    }

    public void setTipoExcusa(TipoExcusa tipoExcusa) {
        this.tipoExcusa = tipoExcusa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
