import java.util.List;
import net.latinus.usuario.integracion.dto.Usuario;
import net.latinus.usuario.integracion.ldap.OperacionesLdap;

public class OperacionesTest {

    public static void main(String[] args) {
        List<String> usuarios = buscarUsuarioPorRol();
        System.out.println("usuarios: " + usuarios);
    }

    public static List<String> buscarUsuarioPorRol() {
        OperacionesLdap c = new OperacionesLdap();
        return c.BuscarUsuariosPorRol("Administrador Registro Civil");
    }
    
}


