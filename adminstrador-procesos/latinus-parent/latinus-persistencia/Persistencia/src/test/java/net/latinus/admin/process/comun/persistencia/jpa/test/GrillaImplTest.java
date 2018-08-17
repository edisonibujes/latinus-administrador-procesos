package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import net.latinus.admin.process.comun.persistencia.jpa.dao.FormularioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GadDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GrillaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Gad;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
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
public class GrillaImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(GrillaImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private GrillaDAO grillaDAO;
    private FormularioDAO formularioDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        grillaDAO = (GrillaDAO) appContext.getBean(GrillaDAO.BEAN_NAME);
        formularioDAO = (FormularioDAO) appContext.getBean(FormularioDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearGrilla() {
        Grilla grilla = new Grilla();
        grilla.setEstadoActual(formularioDAO.read(4));
        grilla.setEstadoAnterior(formularioDAO.read(3));
        grilla.setFuncionTransferencia("(Sin condicion X)");
        grilla.setEstadoSiguiente(formularioDAO.read(6));
        grillaDAO.create(grilla);
    }

    @Test
    @Ignore
    public void leerGrillaPorId() {
        System.out.println("---> " + grillaDAO.read(1).getEstadoActual().getNombre());
    }

    @Test
    @Ignore
    public void actualizarGrilla() {
        Grilla grilla = grillaDAO.read(7);
        grilla.setFuncionTransferencia("(Sin condicion Actualizada)");
        grillaDAO.update(grilla);
    }

    @Test
    @Ignore
    public void obtenerGrillasPorEstadoActual() {
        List<Grilla> grillas = grillaDAO.obtenerGrillasPorEstadoActual(3);
        System.out.println("Size: " + grillas.size());    
    }
    
}
