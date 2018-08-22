package net.latinus.admin.process.comun.persistencia.jpa.dto;

import java.util.ArrayList;
import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

public class RespuestaFuncionDto {
    List<Variable> variables = new ArrayList();
    List<Solicitud> solicitudes = new ArrayList();

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    @Override
    public String toString() {
        return "RespuestaFuncionDto{" + "variables=" + variables + ", solicitudes=" + solicitudes + '}';
    }

}
