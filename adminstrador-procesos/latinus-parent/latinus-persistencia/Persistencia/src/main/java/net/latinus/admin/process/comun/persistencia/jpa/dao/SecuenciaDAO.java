package net.latinus.admin.process.comun.persistencia.jpa.dao;

import net.latinus.admin.process.comun.persistencia.jpa.entidades.Secuencia;

/**
 * Created by Latinus on 25/7/16.
 */
public interface SecuenciaDAO extends GenericoDAO<Secuencia,Integer>{
    public static String BEAN_NAME = "secuenciaDAO";   
    
    public Secuencia obtenerSecuenciaPorIdProceso(Integer idProceso);
    
}
