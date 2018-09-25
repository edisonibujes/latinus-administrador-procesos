package net.latinus.arcom.ws.data.arcom.ws.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.OperacionesDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SeguimientoSolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.TipoEvento;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;


/**
 * @author alejomantillasam
 */
public class ArcomServiciosDataImpl implements ArcomServiciosData {

    private static final Logger LOG = LoggerFactory.getLogger(ArcomServiciosDataImpl.class);
    private TipoEventoDAO tipoEventoDAO;
    private OperacionesDAO operacionesDAO;
    private VariableDAO variableDAO;
    private ProcesoDAO procesoDAO;
    private SolicitudDAO solicitudDAO;
    private SeguimientoSolicitudDAO seguimientoSolicitudDAO;
    
    // Getters Setters DAOs

    public SeguimientoSolicitudDAO getSeguimientoSolicitudDAO() {
        return seguimientoSolicitudDAO;
    }

    public void setSeguimientoSolicitudDAO(SeguimientoSolicitudDAO seguimientoSolicitudDAO) {
        this.seguimientoSolicitudDAO = seguimientoSolicitudDAO;
    }

    public SolicitudDAO getSolicitudDAO() {
        return solicitudDAO;
    }

    public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }
    
    public TipoEventoDAO getTipoEventoDAO() {
        return tipoEventoDAO;
    }

    public void setTipoEventoDAO(TipoEventoDAO tipoEventoDAO) {
        this.tipoEventoDAO = tipoEventoDAO;
    }

    public OperacionesDAO getOperacionesDAO() {
        return operacionesDAO;
    }

    public void setOperacionesDAO(OperacionesDAO operacionesDAO) {
        this.operacionesDAO = operacionesDAO;
    }

    public VariableDAO getVariableDAO() {
        return variableDAO;
    }

    public void setVariableDAO(VariableDAO variableDAO) {
        this.variableDAO = variableDAO;
    }

    public ProcesoDAO getProcesoDAO() {
        return procesoDAO;
    }

    public void setProcesoDAO(ProcesoDAO procesoDAO) {
        this.procesoDAO = procesoDAO;
    }
    
    // Metodos de la interfaz
    
    @Override
    public TipoEvento obtenerTipoEventoPorId(Integer id) {
        return tipoEventoDAO.read(id);
    }

    @Override
    public Integer crearSolicitud(String nombreProceso, List<Variable> listaVariables, String identificacion) {
        return operacionesDAO.crearSolicitud(nombreProceso, listaVariables, identificacion);
    }

    @Override
    public List<Variable> obtenerVariablesPorIdProcesoNumeroTramite(Integer idProceso, Integer numeroTramite) {
        return variableDAO.obtenerVariablesPorIdProcesoNumeroTramite(idProceso, numeroTramite);
    }

    @Override
    public List<Proceso> obtenerProcesos() {
        return procesoDAO.obtenerProcesos();
    }

    @Override
    public Boolean enviarSolicitud(List<Variable> listaVariables, Solicitud solicitud) {
        return operacionesDAO.enviarSolicitud(listaVariables, solicitud);
    }

    @Override
    public List<Solicitud> obtenerSolicitudesPorUsuarioNemonico(String identificacion, String nemonico) {
        return solicitudDAO.obtenerSolicitudesPorUsuarioNemonico(identificacion, nemonico);
    }

    @Override
    public List<SeguimientoSolicitud> obtenerSeguimientoSolicitudPorIdSolicitud(Integer idSolicitud) {
        return seguimientoSolicitudDAO.obtenerSeguimientoPorSolicitud(idSolicitud);
    }

    @Override
    public List<SeguimientoSolicitud> obtenerSeguimientoPorProcesoTramite(Integer idProceso, Integer numeroTramite) {
        return seguimientoSolicitudDAO.obtenerSeguimientoPorProcesoTramite(idProceso, numeroTramite);
    }
    
}
