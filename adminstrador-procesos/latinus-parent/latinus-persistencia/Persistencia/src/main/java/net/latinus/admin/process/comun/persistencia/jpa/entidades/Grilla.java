/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PERSONAL1
 */
@Entity
@Table(name = "grilla", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grilla.findAll", query = "SELECT g FROM Grilla g")})
public class Grilla implements Serializable {

    @Id
    @Column(name = "id_grilla")
    private Long idGrilla;
    
    @Column(name = "funcion_transferencia")
    private String funcionTransferencia;
    
    @JoinColumn(name = "estado_actual", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario estadoActual;
    
    @JoinColumn(name = "estado_anterior", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario estadoAnterior;
    
    @JoinColumn(name = "estado_siguiente", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario estadoSiguiente;

    public Grilla() {
    }

    public Long getIdGrilla() {
        return idGrilla;
    }

    public void setIdGrilla(Long idGrilla) {
        this.idGrilla = idGrilla;
    }

    public String getFuncionTransferencia() {
        return funcionTransferencia;
    }

    public void setFuncionTransferencia(String funcionTransferencia) {
        this.funcionTransferencia = funcionTransferencia;
    }

    public Formulario getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Formulario estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Formulario getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(Formulario estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public Formulario getEstadoSiguiente() {
        return estadoSiguiente;
    }

    public void setEstadoSiguiente(Formulario estadoSiguiente) {
        this.estadoSiguiente = estadoSiguiente;
    }

    @Override
    public String toString() {
        return "Grilla{" + "idGrilla=" + idGrilla + ", funcionTransferencia=" + funcionTransferencia + ", estadoActual=" + estadoActual + ", estadoAnterior=" + estadoAnterior + ", estadoSiguiente=" + estadoSiguiente + '}';
    }

}
