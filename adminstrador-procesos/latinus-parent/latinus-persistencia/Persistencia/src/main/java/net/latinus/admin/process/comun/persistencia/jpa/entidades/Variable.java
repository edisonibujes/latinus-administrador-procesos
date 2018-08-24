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
@Table(name = "variable", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variable.findAll", query = "SELECT v FROM Variable v"),
    @NamedQuery(name = "Variable.findByIdVariable", query = "SELECT v FROM Variable v WHERE v.idVariable = :idVariable"),
    @NamedQuery(name = "Variable.findByNombre", query = "SELECT v FROM Variable v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Variable.findByValor", query = "SELECT v FROM Variable v WHERE v.valor = :valor")})
public class Variable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variable")
    private Long idVariable;    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "numero_tramite")
    private Integer numeroTramite;
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne
    private Proceso idProceso;

    public Variable() {
    }

    public Variable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(Integer numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariable != null ? idVariable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variable)) {
            return false;
        }
        Variable other = (Variable) object;
        if ((this.idVariable == null && other.idVariable != null) || (this.idVariable != null && !this.idVariable.equals(other.idVariable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Variable{" + "idVariable=" + idVariable + ", nombre=" + nombre + ", valor=" + valor + ", idProceso=" + idProceso + '}';
    }
    
}
