
import com.novell.ldap.LDAPConnection;
import net.latinus.usuario.integracion.ldap.ConexionLdap;


public class ConexionTest {
    public static void main(String[] args) {
        ConexionLdap c = new ConexionLdap();
        LDAPConnection l = c.ConexionManager();
        c.CerrarConLDAP(l);
    }
}
