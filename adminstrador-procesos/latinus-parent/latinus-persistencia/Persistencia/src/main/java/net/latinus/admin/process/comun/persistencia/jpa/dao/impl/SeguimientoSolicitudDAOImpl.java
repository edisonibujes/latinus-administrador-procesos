package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SeguimientoSolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;

public class SeguimientoSolicitudDAOImpl extends GenericoDAOImpl<SeguimientoSolicitud, Integer> implements SeguimientoSolicitudDAO {

    public SeguimientoSolicitudDAOImpl() {
        super(SeguimientoSolicitud.class);
    }

    public List<SeguimientoSolicitud> obtenerSeguimientoPorProcesoTramite(Integer idProceso, Integer numeroTramite) {
        List<SeguimientoSolicitud> listaSeguimientoSolicitud;
        try {
            Query query = this.em.createQuery("SELECT ss FROM SeguimientoSolicitud ss WHERE ss.idProceso.idProceso = :idProceso and ss.numeroTramite = :numeroTramite");
            query.setParameter("idProceso", idProceso);
            query.setParameter("numeroTramite", numeroTramite);
            listaSeguimientoSolicitud = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            listaSeguimientoSolicitud = null;
        }
        return listaSeguimientoSolicitud;
    }

    public List<SeguimientoSolicitud> obtenerSeguimientoPorSolicitud(Integer idSolicitud) {
        List<SeguimientoSolicitud> listaSeguimientoSolicitud;
        try {
            Query query = this.em.createQuery("SELECT ss FROM SeguimientoSolicitud ss WHERE ss.idSolicitud.idSolicitud = :idSolicitud");
            query.setParameter("idSolicitud", idSolicitud);
            listaSeguimientoSolicitud = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            listaSeguimientoSolicitud = null;
        }
        return listaSeguimientoSolicitud;
    }
}
