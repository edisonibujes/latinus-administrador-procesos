package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;

/**
 * Created by Latinus on 25/7/16.
 */
public class ProcesoDAOImpl extends GenericoDAOImpl<Proceso, Integer> implements ProcesoDAO {

    public ProcesoDAOImpl() {
        super(Proceso.class);
    }

    public Proceso obtenerProcesoPorNombre(String nombreProceso) {
        Proceso proceso;
        try {
            Query query = this.em.createQuery("SELECT p FROM Proceso p WHERE p.nombre = :nombreProceso");
            query.setParameter("nombreProceso", nombreProceso);
            proceso = (Proceso) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            proceso = null;
        }
        return proceso;
    }

}
