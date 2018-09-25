package net.latinus.arcom.ws.data.arcom.ws.data;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Proceso;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.SeguimientoSolicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.TipoEvento;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

@WebService(targetNamespace = "http://data.ws.arcom.data.ws.arcom.latinus.net/")
public interface ArcomServiciosData {

    public TipoEvento obtenerTipoEventoPorId(
            @WebParam(name = "id") Integer id);

    public List<Proceso> obtenerProcesos();

    public Integer crearSolicitud(
            @WebParam(name = "nombreProceso") String nombreProceso,
            @WebParam(name = "variables") List<Variable> listaVariables,
            @WebParam(name = "identificacion") String identificacion);

    public List<Variable> obtenerVariablesPorIdProcesoNumeroTramite(
            @WebParam(name = "idProceso") Integer idProceso,
            @WebParam(name = "numeroTramite") Integer numeroTramite);

    public Boolean enviarSolicitud(
            @WebParam(name = "variables") List<Variable> listaVariables,
            @WebParam(name = "solicitud") Solicitud solicitud);

    public List<Solicitud> obtenerSolicitudesPorUsuarioNemonico(
            @WebParam(name = "identificacion") String identificacion,
            @WebParam(name = "nemonico") String nemonico
    );

    public List<SeguimientoSolicitud> obtenerSeguimientoSolicitudPorIdSolicitud(
            @WebParam(name = "idSolicitud") Integer idSolicitud
    );
    
    public List<SeguimientoSolicitud> obtenerSeguimientoPorProcesoTramite(
            @WebParam(name = "idProceso") Integer idProceso,
            @WebParam(name = "numeroTramite") Integer numeroTramite
    );
    
}
