package net.latinus.arcom.comun.configuracion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ControladorConfiguracion {

    public static Properties cargarPropiedades() {
        InputStream entrada = null;
        Properties propiedades = new Properties();
        try {
            entrada = Configuracion.class.getResourceAsStream("/configuracion.properties");
            propiedades.load(entrada);
            return propiedades;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (entrada != null) {
                safeInputStream(entrada);
            }
        }
        return null;
    }

    public static void safeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String obtenerParametroUrl(String url, String parametro) {
        String[] URLDatos = url.split("&");
        for (String urlDato : URLDatos) {
            if (urlDato.contains(parametro)) {
                return urlDato.split("=")[1];
            }
        }
        return null;
    }
    
}
