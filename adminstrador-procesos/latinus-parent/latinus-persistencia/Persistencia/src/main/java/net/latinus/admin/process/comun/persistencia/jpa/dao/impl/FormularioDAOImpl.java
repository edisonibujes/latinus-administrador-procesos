package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.FormularioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;

/**
 * Created by Latinus on 25/7/16.
 */
public class FormularioDAOImpl extends GenericoDAOImpl<Formulario, Integer> implements FormularioDAO {

    public FormularioDAOImpl() {
        super(Formulario.class);
    }

    public List<Formulario> obtenerFormulariosPorIdProceso(Integer IdProceso) {
        List<Formulario> formularios;
        try {
            Query query = this.em.createQuery("SELECT f FROM Formulario f WHERE f.idProceso.idProceso = :IdProceso");
            query.setParameter("IdProceso", IdProceso);
            formularios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            formularios = null;
        }
        return formularios;
    }

}
