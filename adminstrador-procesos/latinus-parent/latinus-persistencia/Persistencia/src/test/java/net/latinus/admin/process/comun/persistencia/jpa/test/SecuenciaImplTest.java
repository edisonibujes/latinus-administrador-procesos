package net.latinus.admin.process.comun.persistencia.jpa.test;

import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SecuenciaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Secuencia;
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
public class SecuenciaImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(SecuenciaImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private SecuenciaDAO secuenciaDAO;
    private ProcesoDAO procesoDAO;
    
    
    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        secuenciaDAO = (SecuenciaDAO) appContext.getBean(SecuenciaDAO.BEAN_NAME);
        procesoDAO = (ProcesoDAO) appContext.getBean(ProcesoDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearSecuencia() {
        Secuencia secuencia = new Secuencia();                
        secuencia.setIdProceso(procesoDAO.read(1));
        secuencia.setValor(0);
        secuenciaDAO.create(secuencia);
    }
    
    @Test
    @Ignore
    public void leerSecuencia() {
        System.out.println("---> " + secuenciaDAO.read(1).getValor());
    }
    
    @Test
    @Ignore
    public void actualizarSecuencia() {
        Secuencia secuencia = secuenciaDAO.read(1);
        secuencia.setValor(secuencia.getValor()+1);
        secuenciaDAO.update(secuencia);
    }
    
    @Test
    @Ignore
    public void eliminarSecuencia() {
        Secuencia secuencia = secuenciaDAO.read(2);
        secuenciaDAO.delete(secuencia);
    }
    
}
