package net.latinus.ws.usuario;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.latinus.usuario.integracion.dto.Usuario;

@WebService(targetNamespace = "http://usuario.ws.latinus.net/")
public interface LatinusServiciosUsuario {
    
    public Usuario BuscarUsuarioPorDocumento(
            @WebParam(name = "documento") String documento
    );
    
    public List<String> BuscarUsuariosPorRol(
            @WebParam(name = "rol") String rol
    );
    
    
}
