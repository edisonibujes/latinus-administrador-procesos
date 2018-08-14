package net.latinus.admin.process.comun.persistencia.jpa.dao;

import net.latinus.admin.process.comun.persistencia.jpa.entidades.Evento;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

/**
 * Created by Latinus on 25/7/16.
 */
public interface EventoDAO extends GenericoDAO<Evento,Integer>{
    public static String BEAN_NAME = "eventoDAO";   
}
