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

    public List<Solicitud> obtenerSolicitudesPorIdProcesoNumeroTramite(Integer id_proceso, Integer numero_tramite, Integer id_solicitud_omitida) {
        List<Solicitud> solicitudes;
        try {
            Query query = this.em.createQuery("SELECT s FROM Solicitud s WHERE s.idProceso.idProceso = :id_proceso and s.numeroTramite = :numero_tramite and s.idSolicitud <> :id_solicitud_omitida");
            query.setParameter("id_proceso", id_proceso);
            query.setParameter("numero_tramite", numero_tramite);
            query.setParameter("id_solicitud_omitida", id_solicitud_omitida);
            solicitudes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            solicitudes = null;
        }
        return solicitudes;
    }

    public List<Solicitud> obtenerSolicitudesPorUsuarioNemonico(String identificacion, String nemonico) {
        List<Solicitud> solicitudes;
        try {
            Query query = this.em.createQuery("SELECT s FROM Solicitud s WHERE s.usuarioCreacion.identificacion = :identificacion and s.estadoSolicitud.nemonico = :nemonico");
            query.setParameter("identificacion", identificacion);
            query.setParameter("nemonico", nemonico);
            solicitudes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            solicitudes = null;
        }
        return solicitudes;
    }

}
