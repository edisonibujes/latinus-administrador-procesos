package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;

/**
 * Created by Latinus on 25/7/16.
 */
public class ProcesoDAOImpl extends GenericoDAOImpl<Proceso, Integer> implements ProcesoDAO {

    public ProcesoDAOImpl() {
        super(Proceso.class);
    }

}
