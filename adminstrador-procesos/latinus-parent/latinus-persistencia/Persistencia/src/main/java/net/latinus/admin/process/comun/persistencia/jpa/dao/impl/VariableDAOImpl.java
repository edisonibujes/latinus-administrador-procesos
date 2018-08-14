package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.VariableDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

/**
 * Created by Latinus on 25/7/16.
 */
public class VariableDAOImpl extends GenericoDAOImpl<Variable, Integer> implements VariableDAO {

    public VariableDAOImpl() {
        super(Variable.class);
    }

}
