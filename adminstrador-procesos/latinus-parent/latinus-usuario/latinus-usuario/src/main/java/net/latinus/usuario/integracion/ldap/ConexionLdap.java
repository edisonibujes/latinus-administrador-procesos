package net.latinus.usuario.integracion.ldap;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.latinus.usuario.integracion.controlador.ControladorBase;

public class ConexionLdap extends ControladorBase{

    private int ldapPort;
    private int ldapVersion;
    private LDAPConnection lc;
    private String login;
    
    public ConexionLdap() {
        
    }

    public LDAPConnection ConexionManager() {
        login = strManager;
        ldapPort = LDAPConnection.DEFAULT_PORT;
        ldapVersion = LDAPConnection.LDAP_V3;
        try {
            lc = new LDAPConnection();
            lc.connect(ldapHost, ldapPort);
            lc.bind(ldapVersion, login, strPassword.getBytes("UTF8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ConexionLdap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LDAPException ex) {
            Logger.getLogger(ConexionLdap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lc;
    }

    public void CerrarConLDAP(LDAPConnection lc) {
        try {
            lc.disconnect();
        } catch (LDAPException ex) {
            Logger.getLogger(ConexionLdap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
