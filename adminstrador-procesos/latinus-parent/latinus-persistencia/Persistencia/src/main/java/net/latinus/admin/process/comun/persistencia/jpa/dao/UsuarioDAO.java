package net.latinus.admin.process.comun.persistencia.jpa.dao;

import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Usuario;

/**
 * Created by Latinus on 25/7/16.
 */
public interface UsuarioDAO extends GenericoDAO<Usuario,Integer>{
    public static String BEAN_NAME = "usuarioDAO";   
}
