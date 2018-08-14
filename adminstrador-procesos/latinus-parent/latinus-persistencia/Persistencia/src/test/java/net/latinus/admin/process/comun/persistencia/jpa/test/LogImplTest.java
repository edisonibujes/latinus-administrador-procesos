package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GadDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.LogDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
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
public class LogImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(LogImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private LogDAO logDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        logDAO = (LogDAO) appContext.getBean(LogDAO.BEAN_NAME);
    }

    @Test
    //@Ignore
    public void getAccesosById() {
        System.out.println("---> " + logDAO.read(1).getIdUsuario().getIdentificacion());
    }

}
