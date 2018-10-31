package net.latinus.ws.usuario;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import net.latinus.usuario.integracion.dto.Usuario;
import net.latinus.usuario.integracion.ldap.OperacionesLdap;

public class LatinusServiciosUsuarioImpl implements LatinusServiciosUsuario {

    private static final Logger LOG = LoggerFactory.getLogger(LatinusServiciosUsuarioImpl.class);

    private OperacionesLdap operacionesLdap = new OperacionesLdap();

    // Getters Setters DAOs
    @Override
    public Usuario BuscarUsuarioPorDocumento(String documento) {
        return operacionesLdap.BuscarUsuarioPorDocumento(documento);
    }

    @Override
    public List<String> BuscarUsuariosPorRol(String rol) {
        return operacionesLdap.BuscarUsuariosPorRol(rol);
    }

}
