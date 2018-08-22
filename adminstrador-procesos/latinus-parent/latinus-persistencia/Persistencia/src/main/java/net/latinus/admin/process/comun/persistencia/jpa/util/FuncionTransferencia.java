package net.latinus.admin.process.comun.persistencia.jpa.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.latinus.admin.process.comun.persistencia.jpa.dto.CondicionalDto;
import net.latinus.admin.process.comun.persistencia.jpa.dto.RespuestaFuncionDto;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Formulario;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Grilla;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Solicitud;
import net.latinus.admin.process.comun.persistencia.jpa.entidades.Variable;

public class FuncionTransferencia implements Serializable {

    List<CondicionalDto> condicionales = new ArrayList();
    Boolean evaluarCondicional;

    Boolean sinCondicion;

    public FuncionTransferencia() {
        //cargarDatosA();
        //cargarDatosB();
        //cargarDatosC();
        //cargarDatosD();
    }

    public static void main(String[] args) {
        List<Variable> variables = new ArrayList();
        Variable var = new Variable();
        var.setNombre("a");
        var.setValor(10);
        variables.add(var);
        
        Solicitud solicitud = new Solicitud();
        FuncionTransferencia funcionTransferencia = new FuncionTransferencia();
        RespuestaFuncionDto resultado = funcionTransferencia.evaluar(variables, solicitud);
        System.out.println(resultado.getSolicitudes().get(0).getIdFormulario());
    }

    public RespuestaFuncionDto evaluar(List<Variable> variables, Solicitud solicitud) {
        RespuestaFuncionDto respuestaFuncionDto = new RespuestaFuncionDto();
        if (evaluarCondicional) {
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

    @Override
    public String toString() {
        return "FuncionTransferencia{" + "condicionales=" + condicionales + ", evaluarCondicional=" + evaluarCondicional + '}';
    }

}
