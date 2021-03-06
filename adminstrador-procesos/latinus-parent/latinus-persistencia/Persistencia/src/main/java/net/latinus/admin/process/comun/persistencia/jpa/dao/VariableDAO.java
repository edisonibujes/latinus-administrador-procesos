package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

/**
 * Created by Latinus on 25/7/16.
 */
public interface VariableDAO extends GenericoDAO<Variable, Integer> {

    public static String BEAN_NAME = "variableDAO";

    public List<Variable> obtenerVariablesPorIdProcesoNumeroTramite(Integer idProceso, Integer numeroTramite);

}
