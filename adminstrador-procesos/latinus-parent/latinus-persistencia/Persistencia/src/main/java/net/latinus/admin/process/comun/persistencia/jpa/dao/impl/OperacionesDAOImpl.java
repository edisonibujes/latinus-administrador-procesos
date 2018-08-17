package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import java.util.List;
import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.GrillaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.OperacionesDAO;
import net.latinus.admin.process.comun.persistencia.jpa.dao.SecuenciaDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Secuencia;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;
import net.latinus.admin.process.comun.persistencia.jpa.jpadao.AbstractJPADAO;

/**
 * Created by Latinus on 25/7/16.
 */
public class OperacionesDAOImpl extends AbstractJPADAO implements OperacionesDAO {

    SecuenciaDAO secuenciaDAO;
    GrillaDAO grillaDAO;

    // Getters y Setters de los DAOs
    public void setSecuenciaDAO(SecuenciaDAO secuenciaDAO) {
        this.secuenciaDAO = secuenciaDAO;
    }

    public SecuenciaDAO getSecuenciaDAO() {
        return secuenciaDAO;
    }

    public GrillaDAO getGrillaDAO() {
        return grillaDAO;
    }

    public void setGrillaDAO(GrillaDAO grillaDAO) {
        this.grillaDAO = grillaDAO;
    }

    // Metodos de la interfaz
    public Long obtenerSecuenciaPorIdProceso(Integer idProceso) {
        Long valor = null;
        Secuencia secuencia = secuenciaDAO.obtenerSecuenciaPorIdProceso(idProceso);
        valor = secuencia.getValor().longValue();
        secuencia.setValor(secuencia.getValor() + 1);
        secuenciaDAO.update(secuencia);
        return valor;
    }

    public Formulario obtenerEstadoSiguiente(List<Variable> variables, Integer estado_actual) {
        List<Grilla> grillas = grillaDAO.obtenerGrillasPorEstadoActual(estado_actual);
        String funcionTransferencia = "";
        if (grillas.size() == 1) {
            if (grillas.get(0).getFuncionTransferencia().equals("(Sin condicion)")) {
                return grillas.get(0).getEstadoSiguiente();
            } else {
                funcionTransferencia = grillas.get(0).getFuncionTransferencia();
                for (Variable var : variables) {
                    if (funcionTransferencia.contains(var.getNombre())) {
                        funcionTransferencia = funcionTransferencia.replace(var.getNombre(), var.getValor().toString());
                    }
                }
            }
        } else {

        }
        System.out.println("Funcion de Transferencia: " + funcionTransferencia);
        return null;
    }

}
