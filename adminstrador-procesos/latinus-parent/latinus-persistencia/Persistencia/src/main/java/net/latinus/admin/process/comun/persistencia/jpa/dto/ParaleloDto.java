/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.dto;

import java.util.ArrayList;
import java.util.List;

public class ParaleloDto {
    
    private Integer idFormularioSiguiente;
    private List<HijosDto> hijosDto = new ArrayList();

    public Integer getIdFormularioSiguiente() {
        return idFormularioSiguiente;
    }

    public void setIdFormularioSiguiente(Integer idFormularioSiguiente) {
        this.idFormularioSiguiente = idFormularioSiguiente;
    }

    public List<HijosDto> getHijosDto() {
        return hijosDto;
    }

    public void setHijosDto(List<HijosDto> hijosDto) {
        this.hijosDto = hijosDto;
    }

    @Override
    public String toString() {
        return "ParaleloDto{" + "idFormularioSiguiente=" + idFormularioSiguiente + ", hijosDto=" + hijosDto + '}';
    }
    
}
