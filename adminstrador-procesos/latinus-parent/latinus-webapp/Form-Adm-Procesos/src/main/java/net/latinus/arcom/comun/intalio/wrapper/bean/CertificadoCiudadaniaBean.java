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
import net.latinus.arcom.ws.data.api.Proceso;
import net.latinus.arcom.ws.data.api.Variable;

@ManagedBean
@ViewScoped
public class CertificadoCiudadaniaBean implements Serializable {

    ControladorBaseImpl controladorBase = new ControladorBaseImpl();
    private List<Proceso> procesos;
    private Proceso procesoSeleccionado;
    private String usuarioLogeado;
    private Integer numeroTramite;

    public CertificadoCiudadaniaBean() {
        procesos = new ArrayList();
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

    public void enviar() {
        System.out.println("Enviar");
        List<Variable> variables = new ArrayList();
        Variable var = new Variable();
        var.setNombre("a");
        var.setValor(0);
        variables.add(var);

        if (procesoSeleccionado.getIdProceso() == 3) {
            Variable var2 = new Variable();
            var2.setNombre("subsana");
            var2.setValor(0);
            variables.add(var2);
        }

        System.out.println("UsuarioLogeado:-" + usuarioLogeado + "-");
        numeroTramite = controladorBase.getArcomServiciosData().crearSolicitud(procesoSeleccionado.getNombre(), variables, usuarioLogeado.trim());
        System.out.println("Numero de Tramite" + numeroTramite);
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

    public String getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(String usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    public Integer getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(Integer numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

}
