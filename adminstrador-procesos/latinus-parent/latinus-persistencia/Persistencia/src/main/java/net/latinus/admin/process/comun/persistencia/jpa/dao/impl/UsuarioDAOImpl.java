package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import net.latinus.admin.process.comun.persistencia.jpa.dao.UsuarioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Usuario;

/**
 * Created by Latinus on 25/7/16.
 */
public class UsuarioDAOImpl extends GenericoDAOImpl<Usuario, Integer> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

}
