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
        Solicitud solicitud = solicitudDAO.read(38);
        List<Variable> variables = variableDAO.obtenerVariablesPorIdProcesoNumeroTramite(solicitud.getIdProceso().getIdProceso(), solicitud.getNumeroTramite());

        for (Variable var : variables) {
            if (var.getNombre().equals("b")) {
                var.setValor(0);
            }
            if (var.getNombre().equals("c")) {
                var.setValor(0);
            }
            if (var.getNombre().equals("d")) {
                var.setValor(0);
            }
            if (var.getNombre().equals("n")) {
                var.setValor(1);
            }
            if (var.getNombre().equals("n1")) {
                var.setValor(0);
            }
            if (var.getNombre().equals("n2")) {
                var.setValor(0);
            }
            if (var.getNombre().equals("n3")) {
                var.setValor(0);
            }
            if (var.getNombre().equals("n4")) {
                var.setValor(0);
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

        Variable var2 = new Variable();
        var2.setNombre("b");
        var2.setValor(0);
        variables.add(var2);
        
        Variable var3 = new Variable();
        var3.setNombre("c");
        var3.setValor(0);
        variables.add(var3);
        
        Variable var4 = new Variable();
        var4.setNombre("d");
        var4.setValor(0);
        variables.add(var4);
        
        Variable var5 = new Variable();
        var5.setNombre("n");
        var5.setValor(0);
        variables.add(var5);
        
        Variable var6 = new Variable();
        var6.setNombre("n1");
        var6.setValor(0);
        variables.add(var6);
        
        Variable var7 = new Variable();
        var7.setNombre("n2");
        var7.setValor(0);
        variables.add(var7);
        
        Variable var8 = new Variable();
        var8.setNombre("n3");
        var8.setValor(0);
        variables.add(var8);
        
        Variable var9 = new Variable();
        var9.setNombre("n4");
        var9.setValor(0);
        variables.add(var9);
        
        Integer numTramite = operacionesDAO.crearSolicitud("PQSF", variables, "1721889515");
        System.out.println(numTramite);
    }

}
