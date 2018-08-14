package net.latinus.admin.process.comun.persistencia.jpa.test;

import net.latinus.admin.process.comun.persistencia.jpa.dao.FormularioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
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
public class FormularioImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(FormularioImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private FormularioDAO formularioDAO;
    private ProcesoDAO procesoDAO;
    
    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        formularioDAO = (FormularioDAO) appContext.getBean(FormularioDAO.BEAN_NAME);
        procesoDAO = (ProcesoDAO) appContext.getBean(ProcesoDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearFormulario() {
        Formulario formulario = new Formulario();
        formulario.setIdProceso(procesoDAO.read(1));
        formulario.setNombre("G");
        formulario.setDescripcion("G-TEST");
        formularioDAO.create(formulario);
    }

    @Test
    @Ignore
    public void leerFormulario() {
        System.out.println("---> " + formularioDAO.read(1).getIdProceso().getDescripcion());
    }
    
    @Test
    @Ignore
    public void actualizarFormulario() {
        Formulario formulario = formularioDAO.read(7);
        formulario.setDescripcion("G-TEST-ACTUALIZAR");
        formularioDAO.update(formulario);
    }
    
    @Test
    @Ignore
    public void eliminarFormulario() {
        Formulario formulario = formularioDAO.read(7);
        formularioDAO.delete(formulario);
    }
    
}
