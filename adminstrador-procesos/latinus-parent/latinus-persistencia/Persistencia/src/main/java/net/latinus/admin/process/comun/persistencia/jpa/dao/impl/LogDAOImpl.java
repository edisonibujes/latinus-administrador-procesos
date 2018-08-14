package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.LogDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Log;

/**
 * Created by Latinus on 25/7/16.
 */
public class LogDAOImpl extends GenericoDAOImpl<Log, Integer> implements LogDAO {

    public LogDAOImpl() {
        super(Log.class);
    }

}
