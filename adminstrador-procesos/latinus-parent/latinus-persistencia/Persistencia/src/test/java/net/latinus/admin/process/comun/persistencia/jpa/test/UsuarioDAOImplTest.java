package net.latinus.admin.process.comun.persistencia.jpa.test;

import net.latinus.admin.process.comun.persistencia.jpa.dao.UsuarioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Usuario;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Latinus on 26/7/16.
 */
public class UsuarioDAOImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioDAOImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private UsuarioDAO usuarioDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        usuarioDAO = (UsuarioDAO) appContext.getBean(UsuarioDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("NombreUsuario");
        usuario.setIdentificacion("1721889599");
        usuario.setApellido("ApUsuario");
        usuarioDAO.create(usuario);
    }

    @Test
    @Ignore
    public void leerUsuario() {
        System.out.println("---> " + usuarioDAO.read(1).getNombre());
    }
    
    @Test
    @Ignore
    public void actualizarUsuario() {
        Usuario usuario = usuarioDAO.read(4);
        usuario.setNombre("Nombre-Actualizado");
        usuarioDAO.update(usuario);
    }
    
    @Test
    @Ignore
    public void eliminarUsuario() {
        Usuario usuario = usuarioDAO.read(4);
        usuarioDAO.delete(usuario);
    }
    
}
