/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.ws.usuario;

import java.util.Properties;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author alejomantillasam
 */
public class ClienteWsData {

    private JaxWsProxyFactoryBean factory;
    private LatinusServiciosUsuario arcomServiciosData;

    public ClienteWsData() {

        System.out.println("Creating client");
        Properties properties = System.getProperties();
        properties.put("org.apache.cxf.stax.allowInsecureParser", "1");
        System.setProperties(properties);

        factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(LatinusServiciosUsuario.class);
//        factory.setAddress(Configuracion.getInstance().getProperty(Configuracion.APACHE_HOST)+ "/arcom-ws-data/arcom-ws-data");         
        factory.setAddress("http://localhost:8080/latinus-ws-usuario/latinus-ws-usuario");
        System.out.println("-----------------------------------------------");
        System.out.println("factory.getAddress : "+factory.getAddress());
        System.out.println("-----------------------------------------------"); 
        arcomServiciosData = (LatinusServiciosUsuario) factory.create();
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
    public LatinusServiciosUsuario getArcomServiciosData() {
        return arcomServiciosData;
    }

    /**
     * @param arcomServiciosData the arcomServiciosData to set
     */
    public void setArcomServiciosData(LatinusServiciosUsuario arcomServiciosData) {
        this.arcomServiciosData = arcomServiciosData;
    }

}
