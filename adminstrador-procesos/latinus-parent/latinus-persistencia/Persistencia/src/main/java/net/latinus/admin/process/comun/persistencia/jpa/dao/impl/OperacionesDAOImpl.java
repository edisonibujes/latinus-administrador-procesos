package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import com.google.gson.Gson;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.EmptyStackException;

import java.util.List;
import javax.persistence.Query;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import net.latinus.admin.process.comun.persistencia.jpa.dao.CatalogoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.FormularioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GrillaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.OperacionesDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SecuenciaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SeguimientoSolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.UsuarioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dto.RespuestaFuncionDto;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Catalogo;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Secuencia;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Usuario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;
import net.latinus.admin.process.comun.persistencia.jpa.jpadao.AbstractJPADAO;
import net.latinus.admin.process.comun.persistencia.jpa.json.FuncionTransferencia;
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
    CatalogoDAO catalogoDAO;
    SeguimientoSolicitudDAO seguimientoSolicitudDAO;

    // Getters y Setters de los DAOs
    public SeguimientoSolicitudDAO getSeguimientoSolicitudDAO() {
        return seguimientoSolicitudDAO;
    }

    public void setSeguimientoSolicitudDAO(SeguimientoSolicitudDAO seguimientoSolicitudDAO) {
        this.seguimientoSolicitudDAO = seguimientoSolicitudDAO;
    }

    public CatalogoDAO getCatalogoDAO() {
        return catalogoDAO;
    }

    public void setCatalogoDAO(CatalogoDAO catalogoDAO) {
        this.catalogoDAO = catalogoDAO;
    }

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

    public Boolean enviarSolicitud(List<Variable> variables, Solicitud solicitud, String usuarioAtencion) {
        try {
            Grilla grilla = grillaDAO.obtenerGrillaPorEstadoActualIdProceso(solicitud.getIdFormulario().getIdFormulario().intValue(), solicitud.getIdProceso().getIdProceso());
            String funcionTransferencia = grilla.getFuncionTransferencia();
            Gson g = new Gson();
            FuncionTransferencia ft = g.fromJson(funcionTransferencia, FuncionTransferencia.class);

            List<Solicitud> solicitudes = new ArrayList<Solicitud>();
            solicitudes.add(solicitud);
            List<Solicitud> sol = solicitudDAO.obtenerSolicitudesPorIdProcesoNumeroTramite(solicitud.getIdProceso().getIdProceso(), solicitud.getNumeroTramite(), solicitud.getIdSolicitud());
            if (sol != null && sol.size() > 0) {
                solicitudes.addAll(sol);
            }

            RespuestaFuncionDto respuesta = ft.evaluar(variables, solicitudes);
            for (Variable var : respuesta.getVariables()) {
                variableDAO.update(var);
            }

            for (int i = 0; i < respuesta.getSolicitudes().size(); i++) {
                if (i == 0) {
                    solicitudDAO.update(respuesta.getSolicitudes().get(i));
                } else {
                    solicitudDAO.create(respuesta.getSolicitudes().get(i));
                }
            }
            // Seguimiento
            if (ft.getEvaluarCondicional()) {
                Solicitud solicitudActual = respuesta.getSolicitudes().get(0);
                if (respuesta.getSolicitudes().get(0).getEstadoSolicitud().getNemonico().equals("SOLFIN")) {
                    List<SeguimientoSolicitud> listaSeguimiento = seguimientoSolicitudDAO.obtenerSeguimientoPorSolicitud(solicitud.getIdSolicitud());
                    SeguimientoSolicitud seguimiento = listaSeguimiento.get(listaSeguimiento.size() - 1);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    seguimiento.setFechaFin(timestamp);
                    Catalogo completado = catalogoDAO.obtenerCatalogoPorNemonico("SOLFIN");
                    seguimiento.setEstado(completado);
                    seguimiento.setUsuario(usuarioAtencion);
                    seguimiento.setVariables(variables.toString());
                    seguimiento.setFuncionTransferencia(ft.toString());
                    seguimiento.setFormularioSiguiente(solicitudActual.getIdFormulario());
                    seguimientoSolicitudDAO.update(seguimiento);
                } else {
                    List<SeguimientoSolicitud> listaSeguimiento = seguimientoSolicitudDAO.obtenerSeguimientoPorSolicitud(solicitud.getIdSolicitud());
                    SeguimientoSolicitud seguimiento = listaSeguimiento.get(listaSeguimiento.size() - 1);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    seguimiento.setFechaFin(timestamp);
                    Catalogo completado = catalogoDAO.obtenerCatalogoPorNemonico("SOLATE");
                    seguimiento.setEstado(completado);
                    seguimiento.setUsuario(usuarioAtencion);
                    seguimiento.setVariables(variables.toString());
                    seguimiento.setFuncionTransferencia(ft.toString());
                    seguimiento.setFormularioSiguiente(solicitudActual.getIdFormulario());
                    seguimientoSolicitudDAO.update(seguimiento);

                    SeguimientoSolicitud seguimientoD = new SeguimientoSolicitud();
                    seguimientoD.setIdProceso(solicitud.getIdProceso());
                    seguimientoD.setNumeroTramite(solicitud.getNumeroTramite());
                    seguimientoD.setFechaInicio(timestamp);
                    Catalogo creado = catalogoDAO.obtenerCatalogoPorNemonico("SOLPEN");
                    seguimientoD.setEstado(creado);
                    seguimientoD.setUsuario("");
                    seguimientoD.setVariables("");
                    seguimientoD.setFuncionTransferencia("");
                    seguimientoD.setIdSolicitud(solicitud);
                    seguimientoD.setFormularioActual(solicitudActual.getIdFormulario());
                    seguimientoSolicitudDAO.create(seguimientoD);
                }
            }

            if (ft.getEvaluarParalelo()) {
                Solicitud solicitudPrimaria = respuesta.getSolicitudes().get(0);
                List<SeguimientoSolicitud> listaSeguimiento = seguimientoSolicitudDAO.obtenerSeguimientoPorSolicitud(solicitudPrimaria.getIdSolicitud());
                SeguimientoSolicitud seguimiento = listaSeguimiento.get(listaSeguimiento.size() - 1);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                seguimiento.setFechaFin(timestamp);
                Catalogo completado = catalogoDAO.obtenerCatalogoPorNemonico("SOLATE");
                seguimiento.setEstado(completado);
                //seguimiento.setUsuario(solicitudPrimaria.getUsuarioCreacion().getIdentificacion());
                seguimiento.setVariables(variables.toString());
                seguimiento.setFuncionTransferencia(ft.toString());
                seguimiento.setFormularioSiguiente(solicitudPrimaria.getIdFormulario());
                seguimientoSolicitudDAO.update(seguimiento);

                SeguimientoSolicitud seguimientoD = new SeguimientoSolicitud();
                seguimientoD.setIdProceso(solicitudPrimaria.getIdProceso());
                seguimientoD.setNumeroTramite(solicitudPrimaria.getNumeroTramite());
                seguimientoD.setFechaInicio(timestamp);
                Catalogo creado = catalogoDAO.obtenerCatalogoPorNemonico("SOLPEN");
                seguimientoD.setEstado(creado);
                seguimientoD.setUsuario("");
                seguimientoD.setVariables("");
                seguimientoD.setFuncionTransferencia("");
                seguimientoD.setIdSolicitud(seguimiento.getIdSolicitud());
                seguimientoD.setFormularioActual(solicitudPrimaria.getIdFormulario());
                seguimientoSolicitudDAO.create(seguimientoD);

                for (int i = 1; i < respuesta.getSolicitudes().size(); i++) {
                    Solicitud solicitudHija = respuesta.getSolicitudes().get(i);
                    SeguimientoSolicitud seguimientoNueva = new SeguimientoSolicitud();
                    seguimientoNueva.setIdProceso(solicitudHija.getIdProceso());
                    seguimientoNueva.setNumeroTramite(solicitudHija.getNumeroTramite());
                    seguimientoNueva.setFechaInicio(timestamp);
                    Catalogo inicio = catalogoDAO.obtenerCatalogoPorNemonico("SOLINI");
                    seguimientoNueva.setEstado(inicio);
                    //seguimientoNueva.setUsuario(solicitudHija.getUsuarioCreacion().getIdentificacion());
                    seguimientoNueva.setVariables("");
                    seguimientoNueva.setFuncionTransferencia("");
                    seguimientoNueva.setIdSolicitud(solicitudHija);
                    seguimientoSolicitudDAO.create(seguimientoNueva);

                    SeguimientoSolicitud seguimientoD2 = new SeguimientoSolicitud();
                    seguimientoD2.setIdProceso(solicitudHija.getIdProceso());
                    seguimientoD2.setNumeroTramite(solicitudHija.getNumeroTramite());
                    seguimientoD2.setFechaInicio(timestamp);
                    seguimientoD2.setEstado(creado);
                    seguimientoD2.setUsuario("");
                    seguimientoD2.setVariables("");
                    seguimientoD2.setFuncionTransferencia("");
                    seguimientoD2.setIdSolicitud(solicitudHija);
                    seguimientoD2.setFormularioActual(solicitudHija.getIdFormulario());
                    seguimientoSolicitudDAO.create(seguimientoD2);
                }
            }

            if (ft.getEvaluarUnion()) {
                Solicitud solicitudActual = respuesta.getSolicitudes().get(0);
                if (solicitudActual.getEstadoSolicitud().getNemonico().equals("SOLATE")) {
                    List<SeguimientoSolicitud> listaSeguimiento = seguimientoSolicitudDAO.obtenerSeguimientoPorSolicitud(solicitudActual.getIdSolicitud());
                    SeguimientoSolicitud seguimientoActual = listaSeguimiento.get(listaSeguimiento.size()-1);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    seguimientoActual.setFechaFin(timestamp);
                    Catalogo atentido = catalogoDAO.obtenerCatalogoPorNemonico("SOLATE");
                    seguimientoActual.setEstado(atentido);
                    //seguimientoActual.setUsuario(solicitudActual.getUsuarioCreacion().getIdentificacion());
                    seguimientoActual.setVariables(variables.toString());
                    seguimientoActual.setFuncionTransferencia(ft.toString());
                    seguimientoSolicitudDAO.update(seguimientoActual);
                }

                if (solicitudActual.getEstadoSolicitud().getNemonico().equals("SOLFIN")) {
                    List<SeguimientoSolicitud> listaSeguimiento = seguimientoSolicitudDAO.obtenerSeguimientoPorSolicitud(solicitudActual.getIdSolicitud());
                    SeguimientoSolicitud seguimientoActual = listaSeguimiento.get(listaSeguimiento.size()-1);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    seguimientoActual.setFechaFin(timestamp);
                    Catalogo atentido = catalogoDAO.obtenerCatalogoPorNemonico("SOLFIN");
                    seguimientoActual.setEstado(atentido);
                    //seguimientoActual.setUsuario(solicitudActual.getUsuarioCreacion().getIdentificacion());
                    seguimientoActual.setVariables(variables.toString());
                    seguimientoActual.setFuncionTransferencia(ft.toString());
                    seguimientoSolicitudDAO.update(seguimientoActual);
                }

                if (solicitudActual.getEstadoSolicitud().getNemonico().equals("SOLPEN")) {
                    List<SeguimientoSolicitud> listaSeguimiento = seguimientoSolicitudDAO.obtenerSeguimientoPorSolicitud(solicitudActual.getIdSolicitud());
                    SeguimientoSolicitud seguimientoActual = listaSeguimiento.get(listaSeguimiento.size()-1);
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    seguimientoActual.setFechaFin(timestamp);
                    Catalogo atentido = catalogoDAO.obtenerCatalogoPorNemonico("SOLATE");
                    seguimientoActual.setEstado(atentido);
                    //seguimientoActual.setUsuario(solicitudActual.getUsuarioCreacion().getIdentificacion());
                    seguimientoActual.setVariables(variables.toString());
                    seguimientoActual.setFuncionTransferencia(ft.toString());
                    seguimientoActual.setFormularioSiguiente(solicitudActual.getIdFormulario());
                    seguimientoSolicitudDAO.update(seguimientoActual);

                    SeguimientoSolicitud seguimientoD = new SeguimientoSolicitud();
                    seguimientoD.setIdProceso(solicitudActual.getIdProceso());
                    seguimientoD.setNumeroTramite(solicitudActual.getNumeroTramite());
                    seguimientoD.setFechaInicio(timestamp);
                    Catalogo pendiente = catalogoDAO.obtenerCatalogoPorNemonico("SOLPEN");
                    seguimientoD.setEstado(pendiente);
                    seguimientoD.setUsuario("");
                    seguimientoD.setVariables("");
                    seguimientoD.setFuncionTransferencia("");
                    seguimientoD.setIdSolicitud(solicitudActual);
                    seguimientoD.setFormularioActual(solicitudActual.getIdFormulario());
                    seguimientoSolicitudDAO.create(seguimientoD);
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
        solicitud.setRolTarea(proceso.getRolSiguiente());
        solicitud.setIdProceso(proceso);
        numeroTramite = obtenerSecuenciaPorIdProceso(proceso.getIdProceso()).intValue();
        solicitud.setNumeroTramite(numeroTramite);
        solicitud.setIdFormulario(formularioDAO.obtenerFormulariosPorIdProceso(proceso.getIdProceso()).get(0));
        solicitud.setUsuarioCreacion(usuarioCreacion);
        solicitud.setEstadoSolicitud(catalogoDAO.obtenerCatalogoPorNemonico("SOLPEN"));
        solicitudDAO.create(solicitud);

        // Variables
        if (variables != null && variables.size() > 0) {
            for (Variable var : variables) {
                var.setNumeroTramite(numeroTramite);
                var.setIdProceso(proceso);
                variableDAO.create(var);
            }
        }

        // Seguimiento
        System.out.println("solicitud: " + solicitud.getIdSolicitud());
        SeguimientoSolicitud seguimiento = new SeguimientoSolicitud();
        seguimiento.setIdProceso(proceso);
        seguimiento.setNumeroTramite(numeroTramite);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        seguimiento.setFechaInicio(timestamp);
        Catalogo inicio = catalogoDAO.obtenerCatalogoPorNemonico("SOLINI");
        seguimiento.setEstado(inicio);
        seguimiento.setUsuario(usuarioCreacion);
        seguimiento.setVariables("");
        seguimiento.setFuncionTransferencia("");
        seguimiento.setIdSolicitud(solicitud);
        seguimientoSolicitudDAO.create(seguimiento);

        SeguimientoSolicitud seguimientoD = new SeguimientoSolicitud();
        seguimientoD.setIdProceso(proceso);
        seguimientoD.setNumeroTramite(numeroTramite);
        seguimientoD.setFechaInicio(timestamp);
        Catalogo creado = catalogoDAO.obtenerCatalogoPorNemonico("SOLPEN");
        seguimientoD.setEstado(creado);
        seguimientoD.setUsuario("");
        seguimientoD.setVariables("");
        seguimientoD.setFuncionTransferencia("");
        seguimientoD.setIdSolicitud(solicitud);
        seguimientoD.setFormularioActual(solicitud.getIdFormulario());
        seguimientoSolicitudDAO.create(seguimientoD);

        return numeroTramite;
    }

    public Grilla obtenerGrillaInicialPorIdProceso(Integer idProceso) {
        Formulario formularioInicial = formularioDAO.obtenerFormulariosPorIdProceso(idProceso).get(0);
        return grillaDAO.obtenerGrillasPorEstadoActual(formularioInicial.getIdFormulario().intValue()).get(0);
    }

}
