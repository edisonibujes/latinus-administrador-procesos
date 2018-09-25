/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.comun.bpm.wrapper.controller.base.impl;

import java.io.Serializable;
import java.util.List;
import net.latinus.arcom.comun.configuracion.Configuracion;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import net.latinus.comun.bpm.wrapper.controller.base.ControladorBase;
import net.latinus.arcom.ws.data.api.ArcomServiciosData;
import net.latinus.arcom.ws.data.api.Proceso;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ControladorBaseImpl implements ControladorBase {

    public static org.slf4j.Logger LOG = LoggerFactory.getLogger(ControladorBaseImpl.class);  
    private static JaxWsProxyFactoryBean factory;
    private ArcomServiciosData arcomServiciosData;

    public ControladorBaseImpl() {
        Properties properties = System.getProperties();
        properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
        System.setProperties(properties);
        factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ArcomServiciosData.class);
        factory.setAddress(Configuracion.getInstance().getProperty(Configuracion.APACHE_HOST) + "/latinus-ws-data/arcom-ws-data");
        System.out.println("-----------------------------------------------");
        System.out.println("factory.getAddress : " + factory.getAddress());
        System.out.println("-----------------------------------------------");
        arcomServiciosData = (ArcomServiciosData) factory.create();
        java.util.Map<String, Object> requestContext = ((javax.xml.ws.BindingProvider) arcomServiciosData).getRequestContext();
        requestContext.put("set-jaxb-validation-event-handler", "false");
    }
    
    // getters y setters 
    public ArcomServiciosData getArcomServiciosData() {
        return arcomServiciosData;
    }

    public void setArcomServiciosData(ArcomServiciosData arcomServiciosData) {
        this.arcomServiciosData = arcomServiciosData;
    }
    
    // metodos de la interfaz
    @Override
    public List<Proceso> obtenerProcesos() {
        return arcomServiciosData.obtenerProcesos();
    }
    
    
}
