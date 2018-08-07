package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Gad;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.TipoEvento;

/**
 * Created by Latinus on 25/7/16.
 */
public interface TipoEventoDAO extends GenericoDAO<TipoEvento,Integer>{
    public static String BEAN_NAME = "tipoEventoDAO";   
}
