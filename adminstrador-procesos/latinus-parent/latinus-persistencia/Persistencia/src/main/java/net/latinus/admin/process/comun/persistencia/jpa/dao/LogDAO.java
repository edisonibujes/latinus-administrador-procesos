package net.latinus.admin.process.comun.persistencia.jpa.dao;

import net.latinus.admin.process.comun.persistencia.jpa.entidades.Log;

/**
 * Created by Latinus on 25/7/16.
 */
public interface LogDAO extends GenericoDAO<Log,Integer>{
    public static String BEAN_NAME = "logDAO";   
}
