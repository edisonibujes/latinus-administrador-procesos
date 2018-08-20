package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;

/**
 * Created by Latinus on 25/7/16.
 */
public interface ProcesoDAO extends GenericoDAO<Proceso,Integer>{
    public static String BEAN_NAME = "procesoDAO";   
    
    public Proceso obtenerProcesoPorNombre(String nombreProceso);
    
    public List<Proceso> obtenerProcesos();
    
}
