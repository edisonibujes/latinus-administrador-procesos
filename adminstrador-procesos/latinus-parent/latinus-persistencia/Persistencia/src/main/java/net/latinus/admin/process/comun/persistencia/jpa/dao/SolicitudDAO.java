package net.latinus.admin.process.comun.persistencia.jpa.dao;

import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;

/**
 * Created by Latinus on 25/7/16.
 */
public interface SolicitudDAO extends GenericoDAO<Solicitud,Integer>{
    public static String BEAN_NAME = "solicitudDAO";   
}
