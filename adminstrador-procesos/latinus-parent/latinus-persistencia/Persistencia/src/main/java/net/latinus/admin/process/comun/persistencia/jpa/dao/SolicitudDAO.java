package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;

/**
 * Created by Latinus on 25/7/16.
 */
public interface SolicitudDAO extends GenericoDAO<Solicitud,Integer>{
    public static String BEAN_NAME = "solicitudDAO";
    
    public List<Solicitud> obtenerSolicitudesPorIdProcesoNumeroTramite(Integer id_proceso, Integer numero_tramite, Integer id_solicitud_omitida);
    
    public List<Solicitud> obtenerSolicitudesPorUsuarioNemonico(String identificacion, String nemonico);
    
}
