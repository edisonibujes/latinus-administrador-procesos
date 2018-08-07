package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GadDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Gad;

/**
 * Created by Latinus on 25/7/16.
 */
public class GadDAOImpl extends GenericoDAOImpl<Gad, Integer> implements GadDAO {

    public GadDAOImpl() {
        super(Gad.class);
    }

    public List<Gad> obtenerAllGads() {
        Query query = em.createQuery("select g from Gad g");
        return query.getResultList();
    }

    public Gad obtenerGadPorCodigoLocalidad(Long localidad) {
        try {
            Query query = em.createQuery("SELECT g FROM Gad g WHERE g.codigoLocalidad.codigoLocalidad = :codigoLocalidad");
            query.setParameter("codigoLocalidad", localidad);
            return (Gad) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
