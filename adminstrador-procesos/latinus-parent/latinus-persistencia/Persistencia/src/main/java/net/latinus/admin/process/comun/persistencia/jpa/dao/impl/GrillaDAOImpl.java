package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GrillaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;

/**
 * Created by Latinus on 25/7/16.
 */
public class GrillaDAOImpl extends GenericoDAOImpl<Grilla, Integer> implements GrillaDAO {

    public GrillaDAOImpl() {
        super(Grilla.class);
    }

    public List<Grilla> obtenerGrillasPorEstadoActual(Integer estadoActual) {
        List<Grilla> grillas;
        try {
            Query query = this.em.createQuery("SELECT g FROM Grilla g WHERE g.estadoActual.idFormulario = :estadoActual");
            query.setParameter("estadoActual", estadoActual);
            grillas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            grillas = null;
        }
        return grillas;
    }

    public Grilla obtenerGrillaPorEstadoActualIdProceso(Integer estadoActual, Integer idProceso) {
        Grilla grilla;
        try {
            Query query = this.em.createQuery("SELECT g FROM Grilla g WHERE g.estadoActual.idFormulario = :estadoActual and g.idProceso.idProceso = :idProceso");
            query.setParameter("estadoActual", estadoActual);
            query.setParameter("idProceso", idProceso);
            grilla = (Grilla) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            grilla = null;
        }
        return grilla;
    }

}
