package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;
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
public class ProcesoImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(ProcesoImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private ProcesoDAO procesoDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        procesoDAO = (ProcesoDAO) appContext.getBean(ProcesoDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void saveProceso() {
        Proceso proceso = new Proceso();
        proceso.setNombre("Nombre-Proceso");
        proceso.setDescripcion("Descripcion-Proceso");
        procesoDAO.create(proceso);
    }

    @Test
    @Ignore
    public void getProcesoById() {
        System.out.println("---> " + procesoDAO.read(1).getNombre());
    }

    @Test
    @Ignore
    public void updateProceso() {
        Proceso proceso = procesoDAO.read(2);
        proceso.setNombre("Proceso-Actualizado");
        procesoDAO.update(proceso);
    }

    @Test
    @Ignore
    public void deleteProceso() {
        Proceso proceso = procesoDAO.read(4);
        procesoDAO.delete(proceso);
    }
    
    @Test
    @Ignore
    public void obtenerProcesoPorNombre() {
        Proceso proceso = procesoDAO.obtenerProcesoPorNombre("Certificado de ciudadanía");
        System.out.println("proceso: " + proceso.getIdProceso());
    }
    
    @Test
    @Ignore
    public void obtenerProcesos() {
        List<Proceso> procesos = procesoDAO.obtenerProcesos();
        System.out.println("proceso: " + procesos.size());
    }
    
}
