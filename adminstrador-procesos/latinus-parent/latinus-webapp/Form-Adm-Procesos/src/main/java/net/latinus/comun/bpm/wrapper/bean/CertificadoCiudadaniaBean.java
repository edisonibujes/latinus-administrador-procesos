/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.comun.bpm.wrapper.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.latinus.comun.bpm.wrapper.controller.base.impl.ControladorBaseImpl;
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

        if (procesoSeleccionado.getIdProceso() == 4) {
            Variable var2 = new Variable();
            var2.setNombre("b");
            var2.setValor(0);
            variables.add(var2);

            Variable var3 = new Variable();
            var3.setNombre("c");
            var3.setValor(0);
            variables.add(var3);

            Variable var4 = new Variable();
            var4.setNombre("d");
            var4.setValor(0);
            variables.add(var4);

            Variable var5 = new Variable();
            var5.setNombre("n1");
            var5.setValor(0);
            variables.add(var5);

            Variable var6 = new Variable();
            var6.setNombre("n2");
            var6.setValor(0);
            variables.add(var6);

            Variable var7 = new Variable();
            var7.setNombre("n3");
            var7.setValor(0);
            variables.add(var7);

            Variable var8 = new Variable();
            var8.setNombre("n4");
            var8.setValor(0);
            variables.add(var8);

            Variable var9 = new Variable();
            var9.setNombre("n");
            var9.setValor(0);
            variables.add(var9);
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
