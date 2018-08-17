package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SecuenciaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Secuencia;

/**
 * Created by Latinus on 25/7/16.
 */
public class SecuenciaDAOImpl extends GenericoDAOImpl<Secuencia, Integer> implements SecuenciaDAO {

    public SecuenciaDAOImpl() {
        super(Secuencia.class);
    }

    public Secuencia obtenerSecuenciaPorIdProceso(Integer idProceso) {
        Secuencia secuencia;
        try {
            Query query = this.em.createQuery("SELECT s FROM Secuencia s WHERE s.idProceso.idProceso = :idProceso");
            query.setParameter("idProceso", idProceso);
            secuencia = (Secuencia) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            secuencia = null;
        }
        return secuencia;
    }
    
}
