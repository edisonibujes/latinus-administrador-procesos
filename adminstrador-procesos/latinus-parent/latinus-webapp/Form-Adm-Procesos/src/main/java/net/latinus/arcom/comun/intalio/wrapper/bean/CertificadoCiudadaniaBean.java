/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.latinus.arcom.comun.intalio.wrapper.controller.base.ControladorBaseSingleton;
import net.latinus.arcom.comun.persistencia.jpa.entidades.AreaMinera;
import net.latinus.arcom.comun.persistencia.jpa.entidades.CostoServicios;
import net.latinus.arcom.comun.persistencia.jpa.entidades.ConceptoPago;
import net.latinus.arcom.comun.persistencia.jpa.entidades.CoordenadaArea;
import net.latinus.arcom.comun.persistencia.jpa.entidades.RequisitosMineria;
import net.latinus.arcom.comun.persistencia.jpa.entidades.LicenciaComercializacion;
import net.latinus.arcom.comun.persistencia.jpa.entidades.ConcesionMinera;
import net.latinus.arcom.comun.persistencia.jpa.entidades.TipoMineria;
import net.latinus.arcom.comun.persistencia.jpa.entidades.PlantaBeneficio;
import net.latinus.arcom.comun.persistencia.jpa.entidades.Usuario;
import net.latinus.arcom.comun.persistencia.jpa.entidades.RegistroPagoObligaciones;
import net.latinus.arcom.comun.persistencia.jpa.entidades.CatalogoDetalle;
import net.latinus.arcom.comun.persistencia.jpa.entidades.CoordenadaCota;
import net.latinus.arcom.comun.persistencia.jpa.entidades.CoordenadaPlanta;
import net.latinus.arcom.ws.data.api.TipoEvento;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class CertificadoCiudadaniaBean implements Serializable {

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
        TipoEvento tipo = ControladorBaseSingleton.getControladorBase().getArcomServiciosData().obtenerTipoEventoPorId(1);
        System.out.println("Tipo: " + tipo.getDescripcion());
    }
            
    // getters setters
    
}
