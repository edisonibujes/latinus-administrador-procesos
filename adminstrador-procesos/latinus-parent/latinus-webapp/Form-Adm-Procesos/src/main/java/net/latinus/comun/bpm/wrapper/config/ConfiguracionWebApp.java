/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.comun.bpm.wrapper.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import net.latinus.arcom.comun.configuracion.Configuracion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
public class ConfiguracionWebApp implements Serializable
{
 
    private static final Logger LOG = LoggerFactory.getLogger(ConfiguracionWebApp.class);
    Properties properties = null;
    
    public ConfiguracionWebApp() {
        InputStream is = null;
        String str = System.getProperties().getProperty(Configuracion.ARCOM_CONFIG);
        if (str == null) {
            is = ConfiguracionWebApp.class.getResourceAsStream("/mensajesWebApp.properties");
            LOG.warn("Property net.latinus.configDirectory is not set.");
            LOG.info("Obteniendo Propiedades del classpath");
        } else {
            try {
                File localFile = new File(str, "mensajes.properties");
                is = new FileInputStream(localFile);
                LOG.info("Property net.latinus.configDirectory is set.");
            } catch (FileNotFoundException ex) {
                LOG.error("Archivo no encontrado", ex);
            }
        }
        //File localFile = new File(str, "EmailWS.properties");
        this.properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException ex) {
            LOG.error("Archivo no encotrado", ex);
        }
    }

    public static ConfiguracionWebApp getInstance() {
        return ConfiguracionHolder.INSTANCE;
    }

    private static class ConfiguracionHolder {

     private static final ConfiguracionWebApp INSTANCE = new ConfiguracionWebApp();
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}
