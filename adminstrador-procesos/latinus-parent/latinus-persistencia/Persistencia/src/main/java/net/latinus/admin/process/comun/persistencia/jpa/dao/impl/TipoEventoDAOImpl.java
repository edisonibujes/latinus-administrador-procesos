package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.TipoEvento;

/**
 * Created by Latinus on 25/7/16.
 */
public class TipoEventoDAOImpl extends GenericoDAOImpl<TipoEvento, Integer> implements TipoEventoDAO {

    public TipoEventoDAOImpl() {
        super(TipoEvento.class);
    }

}
