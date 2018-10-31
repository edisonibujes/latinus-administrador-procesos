package net.latinus.ws.usuario;

import java.util.ArrayList;
import java.util.List;
import net.latinus.usuario.integracion.dto.Usuario;
import net.latinus.usuario.integracion.ldap.OperacionesLdap;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * JaxWsProxyFactoryBean
     */
    public static void main(String[] args) {
        
//        ClienteWsData clienteWsData = new ClienteWsData();
//        ArcomServiciosData arcomServiciosData = clienteWsData.getArcomServiciosData();
//        List<String> lista = arcomServiciosData.BuscarUsuariosPorRol("1718901281");
//        System.out.println("lista: " + lista);
////        System.out.println(us);
//
        OperacionesLdap op = new OperacionesLdap();
        Usuario us = op.BuscarUsuarioPorDocumento("1718901281");
        System.out.println("Usuario: " + us);
    }

}
