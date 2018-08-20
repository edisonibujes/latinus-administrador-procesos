package net.latinus.admin.process.comun.persistencia.jpa.dao;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Usuario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

public interface OperacionesDAO {

    public static String BEAN_NAME = "operacionesDAO";

    public Long obtenerSecuenciaPorIdProceso(Integer idProceso);
    
    public Formulario enviarSolicitud(List<Variable> variables, Integer id_proceso, Integer numero_tramite);
    
    public Integer crearSolicitud(String nombreProceso, List<Variable> variables, String usuarioCreacion);
    
    public Grilla obtenerGrillaInicialPorIdProceso(Integer idProceso);
    
}
