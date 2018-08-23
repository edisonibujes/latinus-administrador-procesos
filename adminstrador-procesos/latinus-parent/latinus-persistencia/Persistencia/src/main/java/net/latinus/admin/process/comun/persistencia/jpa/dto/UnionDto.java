/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.dto;

import java.util.ArrayList;
import java.util.List;

public class UnionDto {

    private Integer idFormularioSiguiente;
    private List<Integer> formulariosUnidos = new ArrayList();

    public Integer getIdFormularioSiguiente() {
        return idFormularioSiguiente;
    }

    public void setIdFormularioSiguiente(Integer idFormularioSiguiente) {
        this.idFormularioSiguiente = idFormularioSiguiente;
    }

    public List<Integer> getFormulariosUnidos() {
        return formulariosUnidos;
    }

    public void setFormulariosUnidos(List<Integer> formulariosUnidos) {
        this.formulariosUnidos = formulariosUnidos;
    }

    @Override
    public String toString() {
        return "UnionDto{" + "idFormularioSiguiente=" + idFormularioSiguiente + ", formulariosUnidos=" + formulariosUnidos + '}';
    }

}
