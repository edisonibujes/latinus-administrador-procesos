/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.latinus.admin.process.comun.persistencia.jpa.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "secuencia", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Secuencia.findAll", query = "SELECT s FROM Secuencia s")})
public class Secuencia implements Serializable {    
    @Id    
    @Column(name = "id_secuencia")
    private Integer idSecuencia;
    
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne
    private Proceso idProceso;
    
    @Column(name = "valor")
    private Integer valor;
    
    public Secuencia() {
        
    }

    public Integer getIdSecuencia() {
        return idSecuencia;
    }

    public void setIdSecuencia(Integer idSecuencia) {
        this.idSecuencia = idSecuencia;
    }

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Secuencia{" + "idSecuencia=" + idSecuencia + ", idProceso=" + idProceso + ", valor=" + valor + '}';
    }

}
