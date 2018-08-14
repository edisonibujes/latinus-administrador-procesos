package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.FormularioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;

/**
 * Created by Latinus on 25/7/16.
 */
public class FormularioDAOImpl extends GenericoDAOImpl<Formulario, Integer> implements FormularioDAO {

    public FormularioDAOImpl() {
        super(Formulario.class);
    }

}
