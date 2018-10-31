package net.latinus.usuario.integracion.ldap;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPSearchResults;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import net.latinus.usuario.integracion.dto.Rol;
import net.latinus.usuario.integracion.dto.Usuario;

public class OperacionesLdap extends CRUD{

    public OperacionesLdap() {
        
    }

    public Usuario BuscarUsuarioPorDocumento(String documento) {
        Usuario us = new Usuario();
        LDAPSearchResults searchResults;
        int searchScope = LDAPConnection.SCOPE_SUB;
        try {
            lc = conLDAP.ConexionManager();
            searchResults = lc.search(searchBase, searchScope, "cn=" + documento, null, false);
            //Recorre Todos los Usuarios de la Base
            while (searchResults.hasMore()) {
                LDAPEntry nextEntry = null;
                try {
                    nextEntry = searchResults.next();
                } catch (LDAPException e) {
                    System.out.println("Error: " + e.toString());
                    continue;
                }
                LDAPAttributeSet attributeSet = nextEntry.getAttributeSet();
                Iterator allAttributes = attributeSet.iterator();
                //Recore los atributos del usuario
                while (allAttributes.hasNext()) {
                    LDAPAttribute attribute = (LDAPAttribute) allAttributes.next();
                    String attributeName = attribute.getName();
                    Enumeration allValues = attribute.getStringValues();
                    if (allValues != null) {
                        while (allValues.hasMoreElements()) {
                            String value = (String) allValues.nextElement();
                            if (attributeName.equals("cn")) {
                                us.setCn(value.trim());
                            }
                            if (attributeName.equals("direccionNacimiento")) {
                                us.setDireccionNacimiento(value.trim());
                            }
                            if (attributeName.equals("estadoCuenta")) {
                                us.setEstadoCuenta(value.trim());
                            }
                            if (attributeName.equals("fechaNacimiento")) {
                                us.setFechaNacimiento(value.trim());
                            }
                            if (attributeName.equals("fechaRegistro")) {
                                us.setFechaRegistro(value.trim());
                            }
                            if (attributeName.equals("mail")) {
                                us.setMail(value.trim());
                            }
                            if (attributeName.equals("mobile")) {
                                us.setMobile(value.trim());
                            }
                            if (attributeName.equals("postalAddress")) {
                                us.setPostalAddress(value.trim());
                            }
                        }
                    }
                }
            }
            //Buscar los roles
            String filtro = filtroRol.replace("[documento]", documento);
            searchResults = lc.search(searchBaseRol, searchScope, filtro, null, false);
            while (searchResults.hasMore()) {
                LDAPEntry nextEntry = null;
                try {
                    nextEntry = searchResults.next();
                } catch (LDAPException e) {
                    System.out.println("Error: " + e.toString());
                    continue;
                }
                LDAPAttributeSet attributeSet = nextEntry.getAttributeSet();
                Iterator allAttributes = attributeSet.iterator();
                //Recore los roles del usuario
                while (allAttributes.hasNext()) {
                    LDAPAttribute attribute = (LDAPAttribute) allAttributes.next();
                    String attributeName = attribute.getName();
                    Enumeration allValues = attribute.getStringValues();
                    if (allValues != null) {
                        while (allValues.hasMoreElements()) {
                            String value = (String) allValues.nextElement();
                            if (attributeName.equals("cn")) {
                                Rol rol = new Rol();
                                rol.setNombre(value);
                                us.getRoles().add(rol);
                                break;
                            }
                        }
                    }
                }
            }
            conLDAP.CerrarConLDAP(lc);
        } catch (LDAPException ex) {
            ex.printStackTrace();
        }
        return us;
    }
    
    public List<String> BuscarUsuariosPorRol(String rol) {
        List<String> listaUsuario = new ArrayList();
        LDAPSearchResults searchResults;
        int searchScope = LDAPConnection.SCOPE_SUB;
        try {
            lc = conLDAP.ConexionManager();
            //Buscar los roles
            String filtro = filtroBuscarUsuarioPorRol.replace("[rol]", rol);
            searchResults = lc.search(searchBaseRol, searchScope, filtro, null, false);
            while (searchResults.hasMore()) {
                LDAPEntry nextEntry = null;
                try {
                    nextEntry = searchResults.next();
                } catch (LDAPException e) {
                    System.out.println("Error: " + e.toString());
                    continue;
                }
                LDAPAttributeSet attributeSet = nextEntry.getAttributeSet();
                Iterator allAttributes = attributeSet.iterator();
                //Recore los roles del usuario
                while (allAttributes.hasNext()) {
                    LDAPAttribute attribute = (LDAPAttribute) allAttributes.next();
                    String attributeName = attribute.getName();
                    Enumeration allValues = attribute.getStringValues();
                    if (allValues != null) {
                        while (allValues.hasMoreElements()) {
                            String value = (String) allValues.nextElement();
                            if (attributeName.equals("uniqueMember")) {
                                String documento = value.split(",")[0].replace("cn=", "");
                                listaUsuario.add(documento);
                            }
                        }
                    }
                }
            }
            conLDAP.CerrarConLDAP(lc);
        } catch (LDAPException ex) {
            ex.printStackTrace();
        }
        return listaUsuario;
    }
    
}
