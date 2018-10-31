
import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPEntry;
import net.latinus.usuario.integracion.dto.Usuario;
import net.latinus.usuario.integracion.ldap.CRUD;
import net.latinus.usuario.integracion.ldap.OperacionesLdap;

public class CrudTest {

    public static void main(String[] args) {
        Usuario us = buscar();
        System.out.println("Usuario: " + us);
    }

    public static void add() {
        CRUD c = new CRUD();
        LDAPAttributeSet setAtr = new LDAPAttributeSet();
        setAtr.add(new LDAPAttribute("cn", new String("1721889515")));
        setAtr.add(new LDAPAttribute("mail", new String("JSmith@Acme.com")));
        String dn = "cn=1721889515,ou=Ciudadanos,ou=Administracion,c=ec";
        LDAPEntry newEntry = new LDAPEntry(dn, setAtr);
        c.Añadir(newEntry);
    }

    public static Usuario buscar() {
        OperacionesLdap c = new OperacionesLdap();
        return c.BuscarUsuarioPorDocumento("1718901281");
    }
    
    public static void eliminar() {
        CRUD c = new CRUD();
        c.EliminarPorAtributo("cn=1750038471");
    }
    
    public static void modificar() {
        CRUD c = new CRUD();
        c.Modificar("cn=1717274847","mail", "clientelatinus@gmail.com");
    }
    
}
