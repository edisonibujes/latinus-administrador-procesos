package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.util.ArrayList;
import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.OperacionesDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SolicitudDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;
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
public class OperacionesImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(OperacionesImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private OperacionesDAO operacionesDAO;
    private VariableDAO variableDAO;
    private SolicitudDAO solicitudDAO;
    
    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        operacionesDAO = (OperacionesDAO) appContext.getBean(OperacionesDAO.BEAN_NAME);
        variableDAO = (VariableDAO) appContext.getBean(VariableDAO.BEAN_NAME);
        solicitudDAO = (SolicitudDAO) appContext.getBean(SolicitudDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void obtenerSecuenciaPorIdProceso() {
        Long valor = operacionesDAO.obtenerSecuenciaPorIdProceso(1);
        System.out.println("Valor: " + valor);
    }

    @Test
    @Ignore
    public void obtenerEstadoSiguiente() {
        Solicitud solicitud = solicitudDAO.read(33);
        List<Variable> variables = variableDAO.obtenerVariablesPorIdProcesoNumeroTramite(solicitud.getIdProceso().getIdProceso(), solicitud.getNumeroTramite());
        
        for (Variable var: variables){
            if (var.getNombre().equals("a")){
                var.setValor(100);
            }
        }
        
        System.out.println(operacionesDAO.enviarSolicitud(variables, solicitud));
    }

    @Test
    @Ignore
    public void crearSolicitud() {
        List<Variable> variables = new ArrayList();
        Variable var = new Variable();
        var.setNombre("a");
        var.setValor(0);
        variables.add(var);
  
        Integer numTramite = operacionesDAO.crearSolicitud("Certificado bancario", variables, "1721889515");
        System.out.println(numTramite);
    }

}
