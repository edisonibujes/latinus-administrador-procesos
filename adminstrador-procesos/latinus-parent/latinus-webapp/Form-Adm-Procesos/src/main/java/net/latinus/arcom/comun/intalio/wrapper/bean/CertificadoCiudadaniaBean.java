/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.latinus.arcom.comun.intalio.wrapper.controller.base.impl.ControladorBaseImpl;
import net.latinus.arcom.ws.data.api.Proceso;


@ManagedBean
@ViewScoped
public class CertificadoCiudadaniaBean implements Serializable {
    
    ControladorBaseImpl controladorBase = new ControladorBaseImpl();
    
    public CertificadoCiudadaniaBean() {

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

    }   
    
    public void enviar(){
        //TipoEvento tipo = controladorBase.getArcomServiciosData().obtenerTipoEventoPorId(1);
        //System.out.println("Tipo: " + tipo.getDescripcion());
        List<Proceso> procesos = controladorBase.getArcomServiciosData().obtenerProcesos();
        System.out.println("Procesos" + procesos.size());
    }
            
    // getters setters
    
}
