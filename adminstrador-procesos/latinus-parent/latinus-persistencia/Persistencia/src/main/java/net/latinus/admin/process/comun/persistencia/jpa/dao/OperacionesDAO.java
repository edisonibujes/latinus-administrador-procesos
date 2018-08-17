package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

public interface OperacionesDAO {

    public static String BEAN_NAME = "operacionesDAO";

    public Long obtenerSecuenciaPorIdProceso(Integer idProceso);
    
    public Formulario obtenerEstadoSiguiente(List<Variable> variables, Integer estado_actual);
    
}
