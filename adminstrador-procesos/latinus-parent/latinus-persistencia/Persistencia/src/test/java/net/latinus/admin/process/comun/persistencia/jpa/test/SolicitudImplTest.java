package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.FormularioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.OperacionesDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.UsuarioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.usuario.integracion.dto.Usuario;
import net.latinus.usuario.integracion.ldap.OperacionesLdap;
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
public class SolicitudImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(SolicitudImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private SolicitudDAO solicitudDAO;
    private ProcesoDAO procesoDAO;
    private OperacionesDAO operacionesDAO;
    private FormularioDAO formularioDAO;
    private UsuarioDAO usuarioDAO;
    
    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        solicitudDAO = (SolicitudDAO) appContext.getBean(SolicitudDAO.BEAN_NAME);
        procesoDAO = (ProcesoDAO) appContext.getBean(ProcesoDAO.BEAN_NAME);
        operacionesDAO = (OperacionesDAO) appContext.getBean(OperacionesDAO.BEAN_NAME);
        formularioDAO = (FormularioDAO) appContext.getBean(FormularioDAO.BEAN_NAME);
        usuarioDAO = (UsuarioDAO) appContext.getBean(UsuarioDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearSolicitud() {
        Solicitud solicitud = new Solicitud();                
        solicitud.setIdProceso(procesoDAO.read(1));
        solicitud.setNumeroTramite(operacionesDAO.obtenerSecuenciaPorIdProceso(1).intValue());
        solicitud.setIdFormulario(formularioDAO.read(1));
        //solicitud.setUsuarioCreacion(usuarioDAO.read(1));
        solicitudDAO.create(solicitud);
    }
    
    @Test
    @Ignore
    public void obtenerSolicitudesPorUsuario() {
        List<Solicitud> solicitudes = solicitudDAO.obtenerSolicitudesPorUsuarioNemonico("1718901281", "SOLPEN");
        System.out.println("Lista: " + solicitudes.size());
    }
    
//    @Test
//    @Ignore
//    public void leerEvento() {
//        System.out.println("---> " + eventoDAO.read(1).getIdGrilla().getEstadoActual());
//    }
//    
//    @Test
//    @Ignore
//    public void actualizarEvento() {
//        Evento evento = eventoDAO.read(3);
//        evento.setIdGrilla(grillaDAO.read(5));
//        eventoDAO.update(evento);
//    }
//    
//    @Test
//    @Ignore
//    public void eliminarEvento() {
//        Evento evento = eventoDAO.read(3);
//        eventoDAO.delete(evento);
//    }
    
}
