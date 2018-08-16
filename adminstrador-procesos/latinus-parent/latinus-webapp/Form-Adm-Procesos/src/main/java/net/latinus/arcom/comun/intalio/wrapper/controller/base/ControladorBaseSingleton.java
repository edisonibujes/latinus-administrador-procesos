/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.intalio.wrapper.controller.base;

import java.io.Serializable;
import net.latinus.arcom.comun.configuracion.Configuracion;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import net.latinus.arcom.ws.data.api.ArcomServiciosData;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ControladorBaseSingleton implements Serializable {

    public static org.slf4j.Logger LOG = LoggerFactory.getLogger(ControladorBaseSingleton.class);  
    private static JaxWsProxyFactoryBean factory;
    private ArcomServiciosData arcomServiciosData;
    private static ControladorBaseSingleton miControladorBase;

    public static ControladorBaseSingleton getControladorBase() {
        if (miControladorBase == null) {
            System.out.println("*********El Controlador BASE Singleton se ha creado*********");
            miControladorBase = new ControladorBaseSingleton();
        }
        return miControladorBase;
    }

    private ControladorBaseSingleton() {
        Properties properties = System.getProperties();
        properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
        System.setProperties(properties);
        factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ArcomServiciosData.class);
        factory.setAddress(Configuracion.getInstance().getProperty(Configuracion.APACHE_HOST) + "/arcom-ws-data/arcom-ws-data");
        System.out.println("-----------------------------------------------");
        System.out.println("factory.getAddress : " + factory.getAddress());
        System.out.println("-----------------------------------------------");
        arcomServiciosData = (ArcomServiciosData) factory.create();
        java.util.Map<String, Object> requestContext = ((javax.xml.ws.BindingProvider) arcomServiciosData).getRequestContext();
        requestContext.put("set-jaxb-validation-event-handler", "false");
    }

    public ArcomServiciosData getArcomServiciosData() {
        return arcomServiciosData;
    }

    public void setArcomServiciosData(ArcomServiciosData arcomServiciosData) {
        this.arcomServiciosData = arcomServiciosData;
    }
    
    
}
