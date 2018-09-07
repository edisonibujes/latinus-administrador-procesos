package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.SeguimientoSolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;

public class SeguimientoSolicitudDAOImpl extends GenericoDAOImpl<SeguimientoSolicitud, Integer> implements SeguimientoSolicitudDAO {

    public SeguimientoSolicitudDAOImpl() {
        super(SeguimientoSolicitud.class);
    }

}
