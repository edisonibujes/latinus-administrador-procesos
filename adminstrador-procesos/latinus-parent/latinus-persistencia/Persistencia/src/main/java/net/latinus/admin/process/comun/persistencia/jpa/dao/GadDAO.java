package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Gad;

/**
 * Created by Latinus on 25/7/16.
 */
public interface GadDAO extends GenericoDAO<Gad,Integer>{
    public static String BEAN_NAME = "gadDAO";

    List<Gad> obtenerAllGads();
    
    public Gad obtenerGadPorCodigoLocalidad(Long localidad);
    
}
