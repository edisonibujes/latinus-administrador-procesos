package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import net.latinus.admin.process.comun.persistencia.jpa.dao.FormularioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GrillaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.OperacionesDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SecuenciaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.UsuarioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Secuencia;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Usuario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;
import net.latinus.admin.process.comun.persistencia.jpa.jpadao.AbstractJPADAO;
import org.springframework.web.util.ExpressionEvaluationUtils;

/**
 * Created by Latinus on 25/7/16.
 */
public class OperacionesDAOImpl extends AbstractJPADAO implements OperacionesDAO {

    SecuenciaDAO secuenciaDAO;
    GrillaDAO grillaDAO;
    SolicitudDAO solicitudDAO;
    ProcesoDAO procesoDAO;
    VariableDAO variableDAO;
    UsuarioDAO usuarioDAO;
    FormularioDAO formularioDAO;

    // Getters y Setters de los DAOs
    public void setSecuenciaDAO(SecuenciaDAO secuenciaDAO) {
        this.secuenciaDAO = secuenciaDAO;
    }

    public SecuenciaDAO getSecuenciaDAO() {
        return secuenciaDAO;
    }

    public GrillaDAO getGrillaDAO() {
        return grillaDAO;
    }

    public void setGrillaDAO(GrillaDAO grillaDAO) {
        this.grillaDAO = grillaDAO;
    }

    public SolicitudDAO getSolicitudDAO() {
        return solicitudDAO;
    }

    public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
        this.solicitudDAO = solicitudDAO;
    }

    public ProcesoDAO getProcesoDAO() {
        return procesoDAO;
    }

    public void setProcesoDAO(ProcesoDAO procesoDAO) {
        this.procesoDAO = procesoDAO;
    }

    public VariableDAO getVariableDAO() {
        return variableDAO;
    }

    public void setVariableDAO(VariableDAO variableDAO) {
        this.variableDAO = variableDAO;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public FormularioDAO getFormularioDAO() {
        return formularioDAO;
    }

    public void setFormularioDAO(FormularioDAO formularioDAO) {
        this.formularioDAO = formularioDAO;
    }

    // Metodos de la interfaz
    public Long obtenerSecuenciaPorIdProceso(Integer idProceso) {
        Long valor = null;
        Secuencia secuencia = secuenciaDAO.obtenerSecuenciaPorIdProceso(idProceso);
        valor = secuencia.getValor().longValue();
        secuencia.setValor(secuencia.getValor() + 1);
        secuenciaDAO.update(secuencia);
        return valor;
    }

    public Formulario enviarSolicitud(List<Variable> variables, Integer id_proceso, Integer numero_tramite) {
        Solicitud solicitud = solicitudDAO.obtenerSolicitudPorIdProcesoNumeroTramite(id_proceso, numero_tramite);
        Integer estado_actual = solicitud.getIdFormulario().getIdFormulario().intValue();
        List<Grilla> grillas = grillaDAO.obtenerGrillasPorEstadoActual(estado_actual);
        String funcionTransferencia = "";
        if (grillas != null && grillas.size() == 1) {
            if (grillas.get(0).getFuncionTransferencia().equals("(Sin condicion)")) {
                Formulario formularioSiguiente = grillas.get(0).getEstadoSiguiente();
                guardarDatos(variables, formularioSiguiente, solicitud);
                return formularioSiguiente;
            } else {
                funcionTransferencia = grillas.get(0).getFuncionTransferencia();
                for (Variable var : variables) {
                    if (funcionTransferencia.contains(var.getNombre())) {
                        funcionTransferencia = funcionTransferencia.replace(var.getNombre(), var.getValor().toString());
                    }
                }
                if (Boolean.parseBoolean(funcionTransferencia)) {
                    Formulario formularioSiguiente = grillas.get(0).getEstadoSiguiente();
                    guardarDatos(variables, formularioSiguiente, solicitud);
                    return formularioSiguiente;
                }
            }
        } else if (grillas != null && grillas.size() > 0) {
            for (Grilla grilla : grillas) {
                funcionTransferencia = grilla.getFuncionTransferencia();
                for (Variable var : variables) {
                    if (funcionTransferencia.contains(var.getNombre())) {
                        funcionTransferencia = funcionTransferencia.replace(var.getNombre(), var.getValor().toString());
                    }
                }
                if (evaluarString(funcionTransferencia)) {
                    Formulario formularioSiguiente = grilla.getEstadoSiguiente();
                    guardarDatos(variables, formularioSiguiente, solicitud);
                    return formularioSiguiente;
                }
            }
        }

        Formulario formularioSiguiente = solicitud.getIdFormulario();
        return formularioSiguiente;
    }

    private void guardarDatos(List<Variable> variables, Formulario formularioSiguiente, Solicitud solicitud) {
        if (variables != null && variables.size() > 0) {
            for (Variable var : variables) {
                variableDAO.update(var);
            }
        }
        solicitud.setIdFormulario(formularioSiguiente);
        solicitudDAO.update(solicitud);
    }

    private boolean evaluarString(String expresssion) {
        if (expresssion.contains(">")) {
            String dato[] = expresssion.split(">");
            return Integer.parseInt(dato[0]) > Integer.parseInt(dato[1]);
        }

        if (expresssion.contains("<")) {
            String dato[] = expresssion.split("<");
            return Integer.parseInt(dato[0]) < Integer.parseInt(dato[1]);
        }

        return false;
    }

    public Integer crearSolicitud(String nombreProceso, List<Variable> variables, String usuarioCreacion) {
        Integer numeroTramite = -1;
        Solicitud solicitud = new Solicitud();
        Proceso proceso = procesoDAO.obtenerProcesoPorNombre(nombreProceso);
        solicitud.setIdProceso(proceso);
        numeroTramite = obtenerSecuenciaPorIdProceso(proceso.getIdProceso()).intValue();
        solicitud.setNumeroTramite(numeroTramite);
        solicitud.setIdFormulario(formularioDAO.obtenerFormulariosPorIdProceso(proceso.getIdProceso()).get(0));
        solicitud.setUsuarioCreacion(usuarioDAO.obtenerUsuarioPorIdentificacion(usuarioCreacion));
        solicitudDAO.create(solicitud);
        if (variables != null && variables.size() > 0) {
            for (Variable var : variables) {
                var.setNumeroTramite(numeroTramite);
                var.setIdProceso(proceso);
                variableDAO.create(var);
            }
        }
        return numeroTramite;
    }

    public Grilla obtenerGrillaInicialPorIdProceso(Integer idProceso) {
        Formulario formularioInicial = formularioDAO.obtenerFormulariosPorIdProceso(idProceso).get(0);
        return grillaDAO.obtenerGrillasPorEstadoActual(formularioInicial.getIdFormulario().intValue()).get(0);
    }

}
