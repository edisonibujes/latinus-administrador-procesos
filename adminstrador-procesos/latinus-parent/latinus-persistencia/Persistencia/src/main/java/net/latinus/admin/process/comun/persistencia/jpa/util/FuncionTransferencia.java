package net.latinus.admin.process.comun.persistencia.jpa.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dto.CondicionalDto;
import net.latinus.admin.process.comun.persistencia.jpa.dto.HijosDto;
import net.latinus.admin.process.comun.persistencia.jpa.dto.ParaleloDto;
import net.latinus.admin.process.comun.persistencia.jpa.dto.RespuestaFuncionDto;
import net.latinus.admin.process.comun.persistencia.jpa.dto.UnionDto;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Catalogo;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

public class FuncionTransferencia implements Serializable {

    List<CondicionalDto> condicionales = new ArrayList();
    Boolean evaluarCondicional = false;

    Boolean evaluarParalelo = false;
    ParaleloDto paralelo = new ParaleloDto();

    Boolean evaluarUnion = false;
    UnionDto union = new UnionDto();

    Catalogo SolicitudActiva;
    Catalogo SolicitudAtentidad;

    public FuncionTransferencia() {
        cargarEstados();
        //cargarDatosA2();
        //cargarDatosB2();
        //cargarDatosC2();
        //cargarDatosD2();
        //cargarDatosE2();
    }

    public static void main(String[] args) {
        FuncionTransferencia ft = new FuncionTransferencia();
        System.out.println(ft);
    }

    public RespuestaFuncionDto evaluar(List<Variable> variables, List<Solicitud> solicitudes) {
        RespuestaFuncionDto respuestaFuncionDto = new RespuestaFuncionDto();
        if (evaluarCondicional) {
            Solicitud solicitud = solicitudes.get(0);
            for (Variable var : variables) {
                for (CondicionalDto condicionalDto : condicionales) {
                    if (condicionalDto.getNombre().equals(var.getNombre())) {
                        boolean b = compararValor(var.getValor(), condicionalDto);
                        if (b) {
                            Formulario formulario = new Formulario();
                            formulario.setIdFormulario(condicionalDto.getIdFormulario().longValue());
                            solicitud.setIdFormulario(formulario);
                            respuestaFuncionDto.getSolicitudes().add(solicitud);
                            respuestaFuncionDto.setVariables(variables);
                        }
                    }
                }
            }
        }

        if (evaluarParalelo) {
            Solicitud solicitud = solicitudes.get(0);
            // Hilo Principal
            solicitud.setIdFormulario(new Formulario(paralelo.getIdFormularioSiguiente().longValue()));
            respuestaFuncionDto.getSolicitudes().add(solicitud);
            // Hilos Secundarios
            for (HijosDto hijo : paralelo.getHijosDto()) {
                Solicitud solicitudNueva = new Solicitud();
                solicitudNueva.setIdProceso(solicitud.getIdProceso());
                solicitudNueva.setNumeroTramite(solicitud.getNumeroTramite());
                solicitudNueva.setIdFormulario(new Formulario(hijo.getIdFormulario().longValue()));
                solicitudNueva.setEstadoSolicitud(solicitud.getEstadoSolicitud());
                solicitudNueva.setUsuarioCreacion(solicitud.getUsuarioCreacion());
                respuestaFuncionDto.getSolicitudes().add(solicitudNueva);
            }
        }

        if (evaluarUnion) {
            Boolean continuar = false;
            solicitudes.get(0).setEstadoSolicitud(SolicitudAtentidad);
            for (Solicitud sol : solicitudes) {
                for (Integer idForm : union.getFormulariosUnidos()) {
                    if (sol.getEstadoSolicitud().getNemonico().equals(SolicitudAtentidad) && sol.getIdFormulario().getIdFormulario() == idForm.longValue()) {
                        continuar = true;
                    }
                }
            }
            if (continuar) {
                solicitudes.get(0).setEstadoSolicitud(SolicitudActiva);
                solicitudes.get(0).setIdFormulario(new Formulario(union.getIdFormularioSiguiente().longValue()));
                respuestaFuncionDto.getSolicitudes().add(solicitudes.get(0));
            }
        }

        return respuestaFuncionDto;
    }

    private boolean compararValor(Integer valorComparar, CondicionalDto condicional) {
        String operacion = condicional.getOperacion();

        if (operacion.equals(">")) {
            return valorComparar > condicional.getValor();
        }

        if (operacion.equals("<")) {
            return valorComparar < condicional.getValor();
        }

        if (operacion.equals(">=")) {
            return valorComparar >= condicional.getValor();
        }

        if (operacion.equals("<=")) {
            return valorComparar <= condicional.getValor();
        }

        if (operacion.equals("==")) {
            return valorComparar == condicional.getValor();
        }

        if (operacion.equals("!=")) {
            return valorComparar != condicional.getValor();
        }

        if (operacion.equals("true")) {
            return true;
        }

        if (operacion.equals("false")) {
            return false;
        }

        return false;
    }
    
    public void cargarEstados(){
        SolicitudActiva = new Catalogo();
        SolicitudActiva.setIdCatalogo(6L);
        SolicitudActiva.setNombre("Activo");
        SolicitudActiva.setDescripcion("Activo");
        SolicitudActiva.setNemonico("SOLACT");
        
        SolicitudAtentidad = new Catalogo();
        SolicitudAtentidad.setIdCatalogo(8L);
        SolicitudAtentidad.setNombre("Atendido");
        SolicitudAtentidad.setDescripcion("Atendido");
        SolicitudAtentidad.setNemonico("SOLATE");
    }
            
    public void cargarDatosA() {
        CondicionalDto condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(2);
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosB() {
        CondicionalDto condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(3);
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosC() {
        CondicionalDto condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion(">");
        condicional.setValor(30);
        condicional.setIdFormulario(4);
        condicionales.add(condicional);

        condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion("<");
        condicional.setValor(31);
        condicional.setIdFormulario(5);
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosD() {
        CondicionalDto condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(6);
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosE() {
        CondicionalDto condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(6);
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosA2() {
        CondicionalDto condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(8);
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosB2() {
        CondicionalDto condicional = new CondicionalDto();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(9);
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosC2() {
        paralelo = new ParaleloDto();
        paralelo.setIdFormularioSiguiente(10);
        HijosDto hijo = new HijosDto();
        hijo.setIdFormulario(11);
        paralelo.getHijosDto().add(hijo);
        evaluarParalelo = true;
    }

    public void cargarDatosD2() {
        union = new UnionDto();
        union.setIdFormularioSiguiente(12);
        union.getFormulariosUnidos().add(10);
        union.getFormulariosUnidos().add(11);
        evaluarUnion = true;
    }

    public void cargarDatosE2() {
        union = new UnionDto();
        union.setIdFormularioSiguiente(12);
        union.getFormulariosUnidos().add(10);
        union.getFormulariosUnidos().add(11);
        evaluarUnion = true;
    }

    @Override
    public String toString() {
        return "FuncionTransferencia{" + "condicionales=" + condicionales + ", evaluarCondicional=" + evaluarCondicional + ", evaluarParalelo=" + evaluarParalelo + ", paralelo=" + paralelo + ", evaluarUnion=" + evaluarUnion + ", union=" + union + ", SolicitudActiva=" + SolicitudActiva + ", SolicitudAtentidad=" + SolicitudAtentidad + '}';
    }

}
