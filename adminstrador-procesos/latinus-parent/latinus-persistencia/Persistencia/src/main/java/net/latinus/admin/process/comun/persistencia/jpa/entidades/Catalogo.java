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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "catalogo", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c")})
public class Catalogo implements Serializable {

    @Id
    @Column(name = "id_catalogo")
    private Long idCatalogo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nemonico")
    private String nemonico;

    @JoinColumn(name = "catalogo_padre", referencedColumnName = "id_catalogo")
    @ManyToOne
    private Catalogo catalogoPadre;

    public Catalogo() {
    }

    public Catalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNemonico() {
        return nemonico;
    }

    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
    }

    public Catalogo getCatalogoPadre() {
        return catalogoPadre;
    }

    public void setCatalogoPadre(Catalogo catalogoPadre) {
        this.catalogoPadre = catalogoPadre;
    }

    @Override
    public String toString() {
        return "Catalogo{" + "idCatalogo=" + idCatalogo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nemonico=" + nemonico + ", catalogoPadre=" + catalogoPadre + '}';
    }

}
