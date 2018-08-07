/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.latinus.admin.process.comun.persistencia.jpa.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alejomantillasam
 */
@Entity
@Table(name = "gad", schema = "catmin")
@NamedQueries({
    @NamedQuery(name = "Gad.findAll", query = "SELECT g FROM Gad g"),
    @NamedQuery(name = "Gad.findByIdGad", query = "SELECT g FROM Gad g WHERE g.idGad = :idGad"),
    @NamedQuery(name = "Gad.findByNombre", query = "SELECT g FROM Gad g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Gad.findBySiglas", query = "SELECT g FROM Gad g WHERE g.siglas = :siglas")})
public class Gad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "id_gad")
    private Integer idGad;    
    @Column(name = "nombre")
    private String nombre;    
    @Column(name = "siglas")
    private String siglas;
    @Column(name = "base_ldap")
    private String baseLdap;

    public Gad() {
    }

    public Gad(Integer idGad) {
        this.idGad = idGad;
    }

    public Integer getIdGad() {
        return idGad;
    }

    public void setIdGad(Integer idGad) {
        this.idGad = idGad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getBaseLdap() {
        return baseLdap;
    }

    public void setBaseLdap(String baseLdap) {
        this.baseLdap = baseLdap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGad != null ? idGad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gad)) {
            return false;
        }
        Gad other = (Gad) object;
        if ((this.idGad == null && other.idGad != null) || (this.idGad != null && !this.idGad.equals(other.idGad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.latinus.arcom.comun.persistencia.jpa.entidades.Gad[ idGad=" + idGad + " ]";
    }
    
}
