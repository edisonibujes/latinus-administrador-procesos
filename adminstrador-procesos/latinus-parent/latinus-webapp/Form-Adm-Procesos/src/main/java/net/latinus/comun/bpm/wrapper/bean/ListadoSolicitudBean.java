/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.comun.bpm.wrapper.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.latinus.comun.bpm.wrapper.controller.base.impl.ControladorBaseImpl;
import net.latinus.arcom.ws.data.api.Formulario;
import net.latinus.arcom.ws.data.api.Proceso;
import net.latinus.arcom.ws.data.api.SeguimientoSolicitud;
import net.latinus.arcom.ws.data.api.Solicitud;
import net.latinus.arcom.ws.data.api.Variable;

@ManagedBean
@ViewScoped
public class ListadoSolicitudBean implements Serializable {

    ControladorBaseImpl controladorBase = new ControladorBaseImpl();
    private List<Proceso> procesos;
    private Proceso procesoSeleccionado;
    private String identificacionUsuario;
    private Integer numeroTramite;
    private List<Solicitud> solicitudes;
    private List<Variable> variables;
    private Solicitud solicitudSeleccionado;
    private List<SeguimientoSolicitud> listaSeguimiento;
    
    public ListadoSolicitudBean() {
        procesos = new ArrayList();
        solicitudes = new ArrayList();
        variables = new ArrayList();
        listaSeguimiento = new ArrayList();
    }

    @PostConstruct
    public void init() {
        try {
            obtenerDatos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void obtenerDatos() {
        procesos.addAll(controladorBase.getArcomServiciosData().obtenerProcesos());
    }

    public void cargarDatosSeleccion() {
        variables.clear();
        variables = controladorBase.getArcomServiciosData().obtenerVariablesPorIdProcesoNumeroTramite(solicitudSeleccionado.getIdProceso().getIdProceso(), solicitudSeleccionado.getNumeroTramite());
        
    }

    public void listarSolicitudes() {
        solicitudes.clear();
        solicitudes.addAll(controladorBase.getArcomServiciosData().obtenerSolicitudesPorUsuarioNemonico(identificacionUsuario, "SOLPEN"));
        solicitudes.addAll(controladorBase.getArcomServiciosData().obtenerSolicitudesPorUsuarioNemonico(identificacionUsuario, "SOLFIN"));
    }
    
    public void listarSeguimiento(){
        listaSeguimiento.clear();
        listaSeguimiento.addAll(controladorBase.getArcomServiciosData().obtenerSeguimientoPorProcesoTramite(solicitudSeleccionado.getIdProceso().getIdProceso(), solicitudSeleccionado.getNumeroTramite()));
    }
    
    public void siguiente() {
        System.out.println("variables: " + variables.get(0).getNombre() + " - "+ variables.get(0).getValor());
        controladorBase.getArcomServiciosData().enviarSolicitud(variables, solicitudSeleccionado);
        listarSolicitudes();
        solicitudSeleccionado = null;
    }

    // getters setters
    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public Proceso getProcesoSeleccionado() {
        return procesoSeleccionado;
    }

    public void setProcesoSeleccionado(Proceso procesoSeleccionado) {
        this.procesoSeleccionado = procesoSeleccionado;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Integer getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(Integer numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    public Solicitud getSolicitudSeleccionado() {
        return solicitudSeleccionado;
    }

    public void setSolicitudSeleccionado(Solicitud solicitudSeleccionado) {
        this.solicitudSeleccionado = solicitudSeleccionado;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public List<SeguimientoSolicitud> getListaSeguimiento() {
        return listaSeguimiento;
    }

    public void setListaSeguimiento(List<SeguimientoSolicitud> listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }

}
