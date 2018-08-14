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
@Table(name = "evento", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")})
public class Evento implements Serializable {

    @Id
    @Column(name = "id_evento")
    private Long idEvento;

    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo_evento")
    @ManyToOne
    private TipoEvento idTipo;

    @JoinColumn(name = "id_grilla", referencedColumnName = "id_grilla")
    @ManyToOne
    private Grilla idGrilla;

    public Evento() {
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public TipoEvento getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoEvento idTipo) {
        this.idTipo = idTipo;
    }

    public Grilla getIdGrilla() {
        return idGrilla;
    }

    public void setIdGrilla(Grilla idGrilla) {
        this.idGrilla = idGrilla;
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", idTipo=" + idTipo + ", idGrilla=" + idGrilla + '}';
    }

}
