package net.latinus.arcom.ws.data.arcom.ws.data;

import java.util.ArrayList;
import java.util.List;
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
        TipoEvento te = arcomServiciosData.obtenerTipoEventoPorId(1);
        System.out.println("---->" + te.getDescripcion());
    }

}
