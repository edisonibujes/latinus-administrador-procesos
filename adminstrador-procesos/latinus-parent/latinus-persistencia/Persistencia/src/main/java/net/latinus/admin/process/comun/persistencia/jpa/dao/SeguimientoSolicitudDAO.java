package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;

/**
 * Created by Latinus on 25/7/16.
 */
public interface SeguimientoSolicitudDAO extends GenericoDAO<SeguimientoSolicitud,Integer>{
    public static String BEAN_NAME = "seguimientoSolicitudDAO";
     
    public List<SeguimientoSolicitud> obtenerSeguimientoPorProcesoTramite(Integer idProceso, Integer numeroTramite);
    
    public List<SeguimientoSolicitud> obtenerSeguimientoPorSolicitud(Integer idSolicitud);
    
}
