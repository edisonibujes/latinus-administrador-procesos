/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.latinus.arcom.comun.intalio.wrapper.controller.base.impl.ControladorBaseImpl;
import net.latinus.arcom.ws.data.api.Formulario;
import net.latinus.arcom.ws.data.api.Proceso;
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
    private Solicitud solicitudSeleccionado;
    
    public ListadoSolicitudBean() {
        procesos = new ArrayList();
        solicitudes = new ArrayList();
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
    
    public void listarSolicitudes(){
        solicitudes.clear();
        solicitudes = controladorBase.getArcomServiciosData().obtenerSolicitudesPorUsuario(identificacionUsuario);
    }
            
    public void siguiente() {
        System.out.println("Enviar");
        List<Variable> variables = controladorBase.getArcomServiciosData().obtenerVariablesPorIdProcesoNumeroTramite(solicitudSeleccionado.getIdProceso().getIdProceso(), solicitudSeleccionado.getNumeroTramite());
        controladorBase.getArcomServiciosData().enviarSolicitud(variables, solicitudSeleccionado.getIdProceso().getIdProceso(), solicitudSeleccionado.getNumeroTramite());
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
    
}
