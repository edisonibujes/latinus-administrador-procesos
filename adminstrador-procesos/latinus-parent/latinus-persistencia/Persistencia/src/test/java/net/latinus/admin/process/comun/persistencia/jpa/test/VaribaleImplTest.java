package net.latinus.admin.process.comun.persistencia.jpa.test;

import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dao.ProcesoDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
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
public class VaribaleImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(VaribaleImplTest.class);
    private static final String APP_CONTEXT_DEV[] = {"context-arcom-persistencia-test.xml"};
    private ApplicationContext appContext;
    private VariableDAO variableDAO;
    private ProcesoDAO procesoDAO;

    @Before
    public void setUp() {
        appContext = (ApplicationContext) new ClassPathXmlApplicationContext(APP_CONTEXT_DEV);
        variableDAO = (VariableDAO) appContext.getBean(VariableDAO.BEAN_NAME);
        procesoDAO = (ProcesoDAO) appContext.getBean(ProcesoDAO.BEAN_NAME);
    }

    @Test
    @Ignore
    public void crearVariable() {
        Variable variable = new Variable();
        variable.setIdProceso(procesoDAO.read(1));
        variable.setNombre("A-P");
        variable.setValor(30);
        variableDAO.create(variable);
    }
    
    @Test
    @Ignore
    public void leerVariableById() {
        System.out.println("---> " + variableDAO.read(1).getIdProceso().getDescripcion());
    }

    @Test
    @Ignore
    public void actualizarVariableById() {
        Variable var = variableDAO.read(2);
        var.setNombre("A-P-Actualizada");
        variableDAO.update(var);
    }
    
    @Test
    @Ignore
    public void eliminarVariableById() {
        Variable var = variableDAO.read(2);
        variableDAO.delete(var);
    }
    
    @Test
    @Ignore
    public void obtenerVariablesPorIdProcesoNumeroTramite() {
        List<Variable> vars = variableDAO.obtenerVariablesPorIdProcesoNumeroTramite(1, 1);
        System.out.println("Lista:" + vars.size());
    }
    
}
