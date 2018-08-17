package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

/**
 * Created by Latinus on 25/7/16.
 */
public interface GrillaDAO extends GenericoDAO<Grilla, Integer> {

    public static String BEAN_NAME = "grillaDAO";

    public List<Grilla> obtenerGrillasPorEstadoActual(Integer estadoActual);

}
