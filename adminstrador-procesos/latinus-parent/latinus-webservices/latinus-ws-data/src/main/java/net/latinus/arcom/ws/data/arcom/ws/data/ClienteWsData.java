/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.ws.data.arcom.ws.data;

import java.util.Properties;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author alejomantillasam
 */
public class ClienteWsData {

    private JaxWsProxyFactoryBean factory;
    private ArcomServiciosData arcomServiciosData;

    public ClienteWsData() {

        System.out.println("Creating client");
        Properties properties = System.getProperties();
        properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
        System.setProperties(properties);

        factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ArcomServiciosData.class);
//        factory.setAddress(Configuracion.getInstance().getProperty(Configuracion.APACHE_HOST)+ "/arcom-ws-data/arcom-ws-data");         
        factory.setAddress("http://localhost:8080/latinus-ws-data/arcom-ws-data");
        System.out.println("-----------------------------------------------");
        System.out.println("factory.getAddress : "+factory.getAddress());
        System.out.println("-----------------------------------------------"); 
        arcomServiciosData = (ArcomServiciosData) factory.create();
        java.util.Map<String, Object> requestContext = ((javax.xml.ws.BindingProvider) arcomServiciosData).getRequestContext();        
        requestContext.put("set-jaxb-validation-event-handler", "false"); 

    }

    /**
     * @return the factory
     */
    public JaxWsProxyFactoryBean getFactory() {
        return factory;
    }

    /**
     * @param factory the factory to set
     */
    public void setFactory(JaxWsProxyFactoryBean factory) {
        this.factory = factory;
    }

    /**
     * @return the arcomServiciosData
     */
    public ArcomServiciosData getArcomServiciosData() {
        return arcomServiciosData;
    }

    /**
     * @param arcomServiciosData the arcomServiciosData to set
     */
    public void setArcomServiciosData(ArcomServiciosData arcomServiciosData) {
        this.arcomServiciosData = arcomServiciosData;
    }

}
