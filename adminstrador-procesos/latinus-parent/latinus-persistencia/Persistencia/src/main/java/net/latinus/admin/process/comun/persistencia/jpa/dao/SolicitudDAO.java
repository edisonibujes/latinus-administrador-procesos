package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;

/**
 * Created by Latinus on 25/7/16.
 */
public interface SolicitudDAO extends GenericoDAO<Solicitud,Integer>{
    public static String BEAN_NAME = "solicitudDAO";
    
    public Solicitud obtenerSolicitudPorIdProcesoNumeroTramite(Integer id_proceso, Integer numero_tramite);
    
    public List<Solicitud> obtenerSolicitudesPorUsuario(String identificacion);
    
}
