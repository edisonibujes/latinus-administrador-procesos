package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GadDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Gad;
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
public class TipoEventoDAOImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(TipoEventoDAOImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private TipoEventoDAO tipoEventoDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        tipoEventoDAO = (TipoEventoDAO) appContext.getBean(TipoEventoDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void getAccesosById() {
        System.out.println("---> " + tipoEventoDAO.read(1).getNemonico());
    }

}
