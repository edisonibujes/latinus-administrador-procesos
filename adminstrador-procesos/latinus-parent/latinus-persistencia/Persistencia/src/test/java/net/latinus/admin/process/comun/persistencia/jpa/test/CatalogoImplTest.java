package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.CatalogoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.EventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GrillaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.TipoEventoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Catalogo;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Evento;
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
public class CatalogoImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(CatalogoImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private CatalogoDAO catalogoDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        catalogoDAO = (CatalogoDAO) appContext.getBean(CatalogoDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearCatalogo() {
        Catalogo catalogo = new Catalogo();                
        catalogo.setNombre("Nombre");
        catalogo.setDescripcion("Descripcion");
        catalogo.setNemonico("Nemonico");
        catalogoDAO.create(catalogo);
    }
    
    @Test
    @Ignore
    public void obtenerCatalogoPorNemonico() {
        Catalogo catalogo = catalogoDAO.obtenerCatalogoPorNemonico("TRA");
        System.out.println("Catalogo: " + catalogo.getDescripcion());
    }
    
    @Test
    @Ignore
    public void catalogosPorNemonicoPadre() {
        List<Catalogo> catalogos = catalogoDAO.catalogosPorNemonicoPadre("ESTSOL");
        System.out.println("Catalogos: " + catalogos.size());
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
