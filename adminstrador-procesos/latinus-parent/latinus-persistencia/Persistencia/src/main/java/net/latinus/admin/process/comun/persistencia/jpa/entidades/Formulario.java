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
@Table(name = "formulario", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formulario.findAll", query = "SELECT f FROM Formulario f")})
public class Formulario implements Serializable {
    @Id
    @Column(name = "id_formulario")
    private Long idFormulario;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne
    private Proceso idProceso;

    @JoinColumn(name = "estado_solicitud", referencedColumnName = "id_catalogo")
    @ManyToOne
    private Catalogo estadoSolicitud;
    
    public Formulario() {
    }

    public Catalogo getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(Catalogo estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Long getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(Long idFormulario) {
        this.idFormulario = idFormulario;
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

    public Proceso getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Proceso idProceso) {
        this.idProceso = idProceso;
    }

    @Override
    public String toString() {
        return "Formulario{" + "idFormulario=" + idFormulario + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idProceso=" + idProceso + ", estadoSolicitud=" + estadoSolicitud + '}';
    }

}
