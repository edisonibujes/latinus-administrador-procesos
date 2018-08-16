package net.latinus.arcom.ws.data.arcom.ws.data;

import javax.jws.WebParam;
import javax.jws.WebService;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.TipoEvento;


@WebService(targetNamespace = "http://data.ws.arcom.data.ws.arcom.latinus.net/")
public interface ArcomServiciosData {

    public TipoEvento obtenerTipoEventoPorId(
            @WebParam(name = "id") Integer id);

}
