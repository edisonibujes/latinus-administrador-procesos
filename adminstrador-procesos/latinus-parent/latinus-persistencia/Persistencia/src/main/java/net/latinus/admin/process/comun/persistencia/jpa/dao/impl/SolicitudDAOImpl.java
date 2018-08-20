package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;

/**
 * Created by Latinus on 25/7/16.
 */
public class SolicitudDAOImpl extends GenericoDAOImpl<Solicitud, Integer> implements SolicitudDAO {

    public SolicitudDAOImpl() {
        super(Solicitud.class);
    }

    public Solicitud obtenerSolicitudPorIdProcesoNumeroTramite(Integer id_proceso, Integer numero_tramite) {
        Solicitud solicitud;
        try {
            Query query = this.em.createQuery("SELECT s FROM Solicitud s WHERE s.idProceso.idProceso = :id_proceso and s.numeroTramite = :numero_tramite");
            query.setParameter("id_proceso", id_proceso);
            query.setParameter("numero_tramite", numero_tramite);
            solicitud = (Solicitud) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            solicitud = null;
        }
        return solicitud;
    }

    public List<Solicitud> obtenerSolicitudesPorUsuario(String identificacion) {
        List<Solicitud> solicitudes;
        try {
            Query query = this.em.createQuery("SELECT s FROM Solicitud s WHERE s.usuarioCreacion.identificacion = :identificacion ");
            query.setParameter("identificacion", identificacion);
            solicitudes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            solicitudes = null;
        }
        return solicitudes;
    }

}
