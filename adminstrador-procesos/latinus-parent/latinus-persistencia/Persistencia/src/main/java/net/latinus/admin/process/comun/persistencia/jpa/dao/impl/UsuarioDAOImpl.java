package net.latinus.admin.process.comun.persistencia.jpa.dao.impl;

import javax.persistence.Query;
import net.latinus.admin.process.comun.persistencia.jpa.dao.UsuarioDAO;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Usuario;

/**
 * Created by Latinus on 25/7/16.
 */
public class UsuarioDAOImpl extends GenericoDAOImpl<Usuario, Integer> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    public Usuario obtenerUsuarioPorIdentificacion(String identificacion) {
        Usuario usuario;
        try {
            Query query = this.em.createQuery("SELECT u FROM Usuario u WHERE u.identificacion = :identificacion");
            query.setParameter("identificacion", identificacion);
            usuario = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            usuario = null;
        }
        return usuario;
    }

}
