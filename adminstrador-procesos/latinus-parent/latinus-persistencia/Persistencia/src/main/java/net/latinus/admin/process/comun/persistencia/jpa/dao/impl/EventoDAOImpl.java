package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.EventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Evento;

/**
 * Created by Latinus on 25/7/16.
 */
public class EventoDAOImpl extends GenericoDAOImpl<Evento, Integer> implements EventoDAO {

    public EventoDAOImpl() {
        super(Evento.class);
    }

}
