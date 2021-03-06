package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;

/**
 * Created by Latinus on 25/7/16.
 */
public interface FormularioDAO extends GenericoDAO<Formulario,Integer>{
    public static String BEAN_NAME = "formularioDAO";   
    
    public List<Formulario> obtenerFormulariosPorIdProceso(Integer IdProceso);
    
}
