package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import net.latinus.admin.process.comun.persistencia.jpa.dao.EventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GadDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GrillaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Evento;
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
public class EventoImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(EventoImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private EventoDAO eventoDAO;
    private TipoEventoDAO tipoEventoDAO;
    private GrillaDAO grillaDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        eventoDAO = (EventoDAO) appContext.getBean(EventoDAO.BEAN_NAME);
        tipoEventoDAO = (TipoEventoDAO) appContext.getBean(TipoEventoDAO.BEAN_NAME);
        grillaDAO = (GrillaDAO) appContext.getBean(GrillaDAO.BEAN_NAME);
    }

    @Test
    //@Ignore
    public void crearEvento() {
        Evento evento = new Evento();                
        evento.setIdTipo(tipoEventoDAO.read(2));
        evento.setIdGrilla(grillaDAO.read(6));
        eventoDAO.create(evento);
    }

    @Test
    @Ignore
    public void leerEvento() {
        System.out.println("---> " + eventoDAO.read(1).getIdGrilla().getEstadoActual());
    }
    
    @Test
    @Ignore
    public void actualizarEvento() {
        Evento evento = eventoDAO.read(3);
        evento.setIdGrilla(grillaDAO.read(5));
        eventoDAO.update(evento);
    }
    
    @Test
    @Ignore
    public void eliminarEvento() {
        Evento evento = eventoDAO.read(3);
        eventoDAO.delete(evento);
    }
    
}
