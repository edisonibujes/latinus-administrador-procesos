import java.util.List;
import net.latinus.usuario.integracion.dto.Usuario;
import net.latinus.usuario.integracion.ldap.OperacionesLdap;

public class OperacionesTest {

    public static void main(String[] args) {
        Usuario us = BuscarUsuarioPorDocumento();
        System.out.println("usuarios: " + us);
    }

    public static Usuario BuscarUsuarioPorDocumento() {
        OperacionesLdap c = new OperacionesLdap();
        return c.BuscarUsuarioPorDocumento("1308930801");
    }
    
}


