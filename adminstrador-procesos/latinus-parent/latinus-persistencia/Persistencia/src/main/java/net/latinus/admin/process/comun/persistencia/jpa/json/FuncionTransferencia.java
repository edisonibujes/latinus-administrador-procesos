package net.latinus.admin.process.comun.persistencia.jpa.json;

import com.google.gson.Gson;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import net.latinus.admin.process.comun.persistencia.jpa.dto.RespuestaFuncionDto;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Catalogo;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;


public class FuncionTransferencia {

    private Catalogo SolicitudInicio;
    private Catalogo SolicitudPendiente;
    private Catalogo SolicitudAtendido;
    private Catalogo SolicitudFinalizado;

    @SerializedName("condicionales")
    @Expose
    private List<Condicionale> condicionales = null;

    @SerializedName("evaluarCondicional")
    @Expose
    private Boolean evaluarCondicional = false;

    @SerializedName("evaluarParalelo")
    @Expose
    private Boolean evaluarParalelo = false;

    @SerializedName("paralelo")
    @Expose
    private Paralelo paralelo;

    @SerializedName("evaluarUnion")
    @Expose
    private Boolean evaluarUnion = false;

    @SerializedName("union")
    @Expose
    private Union union;
    
    public FuncionTransferencia() {
        cargarEstados();
        //cargarDatosE();
    }

    public static void main(String[] args) {
        FuncionTransferencia ft = new FuncionTransferencia();
        Gson g = new Gson();
        String str = g.toJson(ft);
        System.out.println(str);
    }

    public RespuestaFuncionDto evaluar(List<Variable> variables, List<Solicitud> solicitudes) {
        RespuestaFuncionDto respuestaFuncionDto = new RespuestaFuncionDto();
        if (evaluarCondicional) {
            Solicitud solicitud = solicitudes.get(0);
            for (Variable var : variables) {                
                for (Condicionale condicionalDto : condicionales) {
                    if (condicionalDto.getNombre().equals(var.getNombre())) {
                        boolean b = compararValor(var.getValor(), condicionalDto);
                        if (b) {
                            Formulario formulario = new Formulario();
                            formulario.setIdFormulario(condicionalDto.getIdFormulario().longValue());
                            solicitud.setIdFormulario(formulario);
                            solicitud.setEstadoSolicitud(obtenerSolicitudNemonico(condicionalDto.getEstadoSolicitud()));
                            solicitud.setRolTarea(condicionalDto.getRolTarea());
                            respuestaFuncionDto.getSolicitudes().add(solicitud);
                            respuestaFuncionDto.setVariables(variables);
                            System.out.println("respuestaFuncionDto: " + respuestaFuncionDto);
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
            for (Hijo hijo : paralelo.getHijosDto()) {
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
            Boolean continuar = true;
            solicitudes.get(0).setEstadoSolicitud(SolicitudAtendido);
            for (Solicitud sol : solicitudes) {
                if (sol.getEstadoSolicitud().getNemonico().equals("SOLATE") && solicitudContenidaLista(sol, union.getFormulariosUnidos())) {
                } else {
                    continuar = false;
                }
            }
            
            if (continuar) {
                solicitudes.get(0).setEstadoSolicitud(obtenerSolicitudNemonico(union.getEstadoSolicitud()));
                solicitudes.get(0).setIdFormulario(new Formulario(union.getIdFormularioSiguiente().longValue()));
                respuestaFuncionDto.getSolicitudes().add(solicitudes.get(0));
            } else {
                respuestaFuncionDto.getSolicitudes().add(solicitudes.get(0));
            }
        }

        return respuestaFuncionDto;
    }

    private Catalogo obtenerSolicitudNemonico(String nemonico){
        if (SolicitudPendiente.getNemonico().equals(nemonico)){
            return SolicitudPendiente;
        }
        if (SolicitudFinalizado.getNemonico().equals(nemonico)){
            return SolicitudFinalizado;
        }
        return null;
    }
    
    private boolean solicitudContenidaLista(Solicitud solicitud, List<Integer> idFormularios) {
        Boolean pertenece = false;
        for (Integer id : idFormularios) {
            if (solicitud.getIdFormulario().getIdFormulario().longValue() == id) {
                return true;
            }
        }
        return pertenece;
    }

    private boolean compararValor(Integer valorComparar, Condicionale condicional) {
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

        if (operacion.equals("=")) {
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

    public void cargarEstados() {
        SolicitudInicio = new Catalogo();
        SolicitudInicio.setIdCatalogo(2L);
        SolicitudInicio.setNombre("Inicio");
        SolicitudInicio.setDescripcion("Inicio");
        SolicitudInicio.setNemonico("SOLINI");
        
        SolicitudPendiente = new Catalogo();
        SolicitudPendiente.setIdCatalogo(3L);
        SolicitudPendiente.setNombre("Pendiente");
        SolicitudPendiente.setDescripcion("Pendiente");
        SolicitudPendiente.setNemonico("SOLPEN");
        
        SolicitudAtendido = new Catalogo();
        SolicitudAtendido.setIdCatalogo(4L);
        SolicitudAtendido.setNombre("Atendido");
        SolicitudAtendido.setDescripcion("Atendido");
        SolicitudAtendido.setNemonico("SOLATE");
        
        SolicitudFinalizado = new Catalogo();
        SolicitudFinalizado.setIdCatalogo(5L);
        SolicitudFinalizado.setNombre("Finalizado");
        SolicitudFinalizado.setDescripcion("Finalizado");
        SolicitudFinalizado.setNemonico("SOLFIN");
    }

    public void cargarDatosA() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(2);
        condicional.setEstadoSolicitud("SOLPEN");
        condicional.setRolTarea("Administrador");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosB() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(3);
        condicional.setEstadoSolicitud("SOLPEN");
        condicional.setRolTarea("Juridico");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosC() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion(">");
        condicional.setValor(30);
        condicional.setIdFormulario(4);
        condicional.setEstadoSolicitud("SOLPEN");
        condicional.setRolTarea("Juridico");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("<");
        condicional.setValor(31);
        condicional.setIdFormulario(5);
        condicional.setEstadoSolicitud("SOLPEN");
        condicional.setRolTarea("Administrador");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosD() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(6);
        condicional.setEstadoSolicitud("SOLFIN");
        condicional.setRolTarea("Administrador");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosE() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(6);
        condicional.setEstadoSolicitud("SOLFIN");
        condicional.setRolTarea("Administrador");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosA2() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(8);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosB2() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(9);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosC2() {
        paralelo = new Paralelo();
        paralelo.setIdFormularioSiguiente(10);
        Hijo hijo = new Hijo();
        hijo.setIdFormulario(11);
        paralelo.getHijosDto().add(hijo);
        evaluarParalelo = true;
    }

    public void cargarDatosD2() {
        union = new Union();
        union.setIdFormularioSiguiente(12);
        union.getFormulariosUnidos().add(10);
        union.getFormulariosUnidos().add(11);
        union.setEstadoSolicitud("SOLFIN");
        evaluarUnion = true;
    }

    public void cargarDatosE2() {
        union = new Union();
        union.setIdFormularioSiguiente(12);
        union.getFormulariosUnidos().add(10);
        union.getFormulariosUnidos().add(11);
        union.setEstadoSolicitud("SOLFIN");
        evaluarUnion = true;
    }

    public void cargarDatosA3() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(14);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosB3() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(15);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosC3() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion(">");
        condicional.setValor(30);
        condicional.setIdFormulario(16);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("<");
        condicional.setValor(31);
        condicional.setIdFormulario(17);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosD3() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(18);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosE3() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(18);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosF3() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("subsana");
        condicional.setOperacion("==");
        condicional.setValor(0);
        condicional.setIdFormulario(19);
        condicional.setEstadoSolicitud("SOLFIN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("subsana");
        condicional.setOperacion("==");
        condicional.setValor(1);
        condicional.setIdFormulario(14);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosA4() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("a");
        condicional.setOperacion("true");
        condicional.setValor(-1);
        condicional.setIdFormulario(21);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }

    public void cargarDatosB4() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("c");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(22);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("n");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(28);
        condicional.setEstadoSolicitud("SOLFIN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n1");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(24);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n2");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(25);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n3");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(26);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n4");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(27);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        evaluarCondicional = true;
    }
    
    public void cargarDatosC4() {
         condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("d");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(23);
        condicional.setEstadoSolicitud("SOLFIN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("b");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(21);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }
    
    public void cargarDatosN1() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("b");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(21);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("n2");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(25);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(28);
        condicional.setEstadoSolicitud("SOLFIN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }
    
    public void cargarDatosN2() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("b");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(21);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("n1");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(24);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n3");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(26);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(28);
        condicional.setEstadoSolicitud("SOLFIN");
        condicionales.add(condicional);
        evaluarCondicional = true;
    }
    
    public void cargarDatosN3() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("b");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(21);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("n2");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(25);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n4");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(27);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        condicional = new Condicionale();
        condicional.setNombre("n");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(28);
        condicionales.add(condicional);
        condicional.setEstadoSolicitud("SOLFIN");
        evaluarCondicional = true;
    }
    
    public void cargarDatosN4() {
        condicionales = new ArrayList();
        Condicionale condicional = new Condicionale();
        condicional.setNombre("b");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(21);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);

        condicional = new Condicionale();
        condicional.setNombre("n3");
        condicional.setOperacion("=");
        condicional.setValor(1);
        condicional.setIdFormulario(26);
        condicional.setEstadoSolicitud("SOLPEN");
        condicionales.add(condicional);
        
        evaluarCondicional = true;
    }
    
    public List<Condicionale> getCondicionales() {
        return condicionales;
    }

    public void setCondicionales(List<Condicionale> condicionales) {
        this.condicionales = condicionales;
    }

    public Boolean getEvaluarCondicional() {
        return evaluarCondicional;
    }

    public void setEvaluarCondicional(Boolean evaluarCondicional) {
        this.evaluarCondicional = evaluarCondicional;
    }

    public Boolean getEvaluarParalelo() {
        return evaluarParalelo;
    }

    public void setEvaluarParalelo(Boolean evaluarParalelo) {
        this.evaluarParalelo = evaluarParalelo;
    }

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    public Boolean getEvaluarUnion() {
        return evaluarUnion;
    }

    public void setEvaluarUnion(Boolean evaluarUnion) {
        this.evaluarUnion = evaluarUnion;
    }

    public Union getUnion() {
        return union;
    }

    public void setUnion(Union union) {
        this.union = union;
    }

    @Override
    public String toString() {
        return "FuncionTransferencia{" + "condicionales=" + condicionales + ", evaluarCondicional=" + evaluarCondicional + ", evaluarParalelo=" + evaluarParalelo + ", paralelo=" + paralelo + ", evaluarUnion=" + evaluarUnion + ", union=" + union + '}';
    }

}
