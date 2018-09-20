package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SecuenciaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SeguimientoSolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Catalogo;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Secuencia;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;
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
public class SeguimientoSolicitudImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(SeguimientoSolicitudImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private SeguimientoSolicitudDAO seguimientoSolicitudDAO;  
    private SecuenciaDAO secuenciaDAO;  
    
    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        seguimientoSolicitudDAO = (SeguimientoSolicitudDAO) appContext.getBean(SeguimientoSolicitudDAO.BEAN_NAME);
        secuenciaDAO = (SecuenciaDAO) appContext.getBean(SecuenciaDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearSeguimientoSolicitud() {
        SeguimientoSolicitud seguimientoSolicitud = new SeguimientoSolicitud();                
        seguimientoSolicitud.setIdProceso(new Proceso(1));
        seguimientoSolicitud.setEstado(new Catalogo(1L));
        Secuencia secuencia = secuenciaDAO.obtenerSecuenciaPorIdProceso(1);
        seguimientoSolicitud.setNumeroTramite(secuencia.getValor());
        seguimientoSolicitudDAO.create(seguimientoSolicitud);
    }
    
    @Test
    @Ignore
    public void leerSeguimientoSolicitud() {
        System.out.println("---> " + seguimientoSolicitudDAO.read(1));
    }
    
    @Test
    @Ignore
    public void actualizarSeguimientoSolicitud() {
        SeguimientoSolicitud seguimientoSolicitud = seguimientoSolicitudDAO.read(1);
        seguimientoSolicitud.setUsuario("000000000000");
        seguimientoSolicitudDAO.update(seguimientoSolicitud);
    }
    
    @Test
    @Ignore
    public void eliminarSeguimientoSolicitud() {
        SeguimientoSolicitud seguimientoSolicitud = seguimientoSolicitudDAO.read(7);
        seguimientoSolicitudDAO.delete(seguimientoSolicitud);
    }
    
    @Test
    @Ignore
    public void obtenerSeguimientoPorProcesoTramite() {
        List<SeguimientoSolicitud> listaSeguimientoSolicitud = seguimientoSolicitudDAO.obtenerSeguimientoPorProcesoTramite(1, 3);
        System.out.println("--> " + listaSeguimientoSolicitud.size());
    }
    
}
