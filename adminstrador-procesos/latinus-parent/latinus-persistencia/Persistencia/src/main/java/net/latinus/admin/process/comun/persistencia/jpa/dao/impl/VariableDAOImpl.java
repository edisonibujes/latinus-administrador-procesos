package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

/**
 * Created by Latinus on 25/7/16.
 */
public class VariableDAOImpl extends GenericoDAOImpl<Variable, Integer> implements VariableDAO {

    public VariableDAOImpl() {
        super(Variable.class);
    }

    public List<Variable> obtenerVariablesPorIdProcesoNumeroTramite(Integer idProceso, Integer numeroTramite) {
        List<Variable> variables;
        try {
            Query query = this.em.createQuery("SELECT v FROM Variable v WHERE v.idProceso.idProceso = :idProceso and v.numeroTramite = :numeroTramite");
            query.setParameter("idProceso", idProceso);
            query.setParameter("numeroTramite", numeroTramite);
            variables = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            variables = null;
        }
        return variables;
    }

}
