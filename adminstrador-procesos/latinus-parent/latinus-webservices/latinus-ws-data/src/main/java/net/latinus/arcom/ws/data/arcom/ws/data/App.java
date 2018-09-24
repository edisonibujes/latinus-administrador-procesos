package net.latinus.arcom.ws.data.arcom.ws.data;

import java.util.ArrayList;
import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.TipoEvento;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * JaxWsProxyFactoryBean
     */
    public static void main(String[] args) {

        ClienteWsData clienteWsData = new ClienteWsData();
        ArcomServiciosData arcomServiciosData = clienteWsData.getArcomServiciosData();
        List<SeguimientoSolicitud> ss = arcomServiciosData.obtenerSeguimientoSolicitudPorIdSolicitud(4);
        System.out.println("---->" + ss.get(0).getUsuario());
    }

}
