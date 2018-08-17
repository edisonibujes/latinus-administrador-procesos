package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.SolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;

/**
 * Created by Latinus on 25/7/16.
 */
public class SolicitudDAOImpl extends GenericoDAOImpl<Solicitud, Integer> implements SolicitudDAO {

    public SolicitudDAOImpl() {
        super(Solicitud.class);
    }

}
