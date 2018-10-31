package net.latinus.usuario.integracion.controlador;

import java.util.Properties;
import net.latinus.arcom.comun.configuracion.ControladorConfiguracion;

public class ControladorBase {

    protected final Properties propiedades = ControladorConfiguracion.cargarPropiedades();

    final protected String ldapHost = "10.0.0.15";
    final protected String strManager = "cn=Administrador,c=ec";
    final protected String strPassword = "Latinus01";    
    final protected String searchBase = "ou=Ciudadanos,ou=Administracion,c=ec";
    final protected String searchBaseRol = "ou=Roles,ou=Administracion,c=ec";
    final protected String filtroRol = "uniqueMember=cn=[documento],ou=Ciudadanos,ou=Administracion,c=ec";
    final protected String filtroBuscarUsuarioPorRol = "cn=[rol]";
    
}
