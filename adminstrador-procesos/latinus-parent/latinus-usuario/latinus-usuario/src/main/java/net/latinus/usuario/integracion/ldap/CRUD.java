package net.latinus.usuario.integracion.ldap;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPModification;
import com.novell.ldap.LDAPSearchResults;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.latinus.usuario.integracion.controlador.ControladorBase;
import net.latinus.usuario.integracion.dto.Rol;
import net.latinus.usuario.integracion.dto.Usuario;

public class CRUD extends ControladorBase {

    ConexionLdap conLDAP = new ConexionLdap();
    LDAPConnection lc = new LDAPConnection();

    
    public CRUD() {
        
    }

    public void Añadir(LDAPEntry usuario) {
        try {
            lc = conLDAP.ConexionManager();
            lc.add(usuario);
            conLDAP.CerrarConLDAP(lc);
            System.out.println("Usuario Ingresado Correctamente...");
        } catch (LDAPException ex) {
            if (ex.getResultCode() == 68) {
                System.err.println("ERROR:El Usuario ya se encuentra ingresado...");
            }
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EliminarPorAtributo(String atributo) {
        String dn = atributo + "," + searchBase;
        try {
            lc = conLDAP.ConexionManager();
            lc.delete(dn);
            System.out.println("\nEntry: " + dn + " Fue Eliminado Correctamente...");
            conLDAP.CerrarConLDAP(lc);
        } catch (LDAPException e) {
            if (e.getResultCode() == LDAPException.NO_SUCH_OBJECT) {
                System.err.println("Error: NO existe ese usuario...");
            } else if (e.getResultCode() == LDAPException.INSUFFICIENT_ACCESS_RIGHTS) {
                System.err.println("Error: NO tiene permisos suficientes para realizar esta transaccion...");
            } else {
                System.err.println("Error: " + e.toString());
            }
        }
    }

    public void Modificar(String cn, String atributo, String valorAtributo) {
        try {
            LDAPAttribute atrubuto;
            lc = conLDAP.ConexionManager();
            atrubuto = new LDAPAttribute(atributo, valorAtributo);
            String dn = cn + "," + searchBase;
            lc.modify(dn, new LDAPModification(LDAPModification.REPLACE, atrubuto));
            System.out.println("Atributo Modificado OK...");
        } catch (LDAPException ex) {
            ex.printStackTrace();
            if (ex.getResultCode() == LDAPException.INSUFFICIENT_ACCESS_RIGHTS) {
                System.err.println("Error: NO tiene permisos suficientes para realizar esta transaccion...");
            }
        }
    }

}
