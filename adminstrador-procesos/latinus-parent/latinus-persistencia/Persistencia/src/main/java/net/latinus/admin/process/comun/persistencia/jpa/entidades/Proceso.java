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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "proceso", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")})
public class Proceso implements Serializable {    
    @Id    
    @Column(name = "id_proceso")
    private Integer idProceso;
    
    @Column(name = "nombre")
    private String nombre;  
    
    @Column(name = "descripcion")
    private String descripcion;
    
    public Proceso() {
        
    }
    
    public Proceso(Integer idProceso) {
        this.idProceso = idProceso;
    }
    
    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
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

    @Override
    public String toString() {
        return "Proceso{" + "idProceso=" + idProceso + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
