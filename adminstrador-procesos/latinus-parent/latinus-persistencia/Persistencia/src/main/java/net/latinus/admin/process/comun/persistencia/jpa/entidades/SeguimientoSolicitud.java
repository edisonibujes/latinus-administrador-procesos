/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.latinus.admin.process.comun.persistencia.jpa.entidades;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "seguimiento_solicitud", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SeguimientoSolicitud.findAll", query = "SELECT s FROM SeguimientoSolicitud s")})
public class SeguimientoSolicitud implements Serializable {    
    @Id    
    @Column(name = "id_seguimiento_solicitud")
    private Integer idSeguimientoSolicitud;
    
    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
    @ManyToOne
    private Solicitud idSolicitud;
    
    @Column(name = "numero_tramite")
    private Integer numeroTramite;
    
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @JoinColumn(name = "estado", referencedColumnName = "id_catalogo")
    @ManyToOne
    private Catalogo estado;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "variables")
    private String variables;
    
    @Column(name = "funcion_transferencia")
    private String funcionTransferencia;
    
    public SeguimientoSolicitud() {
        
    }

    public Integer getIdSeguimientoSolicitud() {
        return idSeguimientoSolicitud;
    }

    public void setIdSeguimientoSolicitud(Integer idSeguimientoSolicitud) {
        this.idSeguimientoSolicitud = idSeguimientoSolicitud;
    }

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(Integer numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Catalogo getEstado() {
        return estado;
    }

    public void setEstado(Catalogo estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getVariables() {
        return variables;
    }

    public void setVariables(String variables) {
        this.variables = variables;
    }

    public String getFuncionTransferencia() {
        return funcionTransferencia;
    }

    public void setFuncionTransferencia(String funcionTransferencia) {
        this.funcionTransferencia = funcionTransferencia;
    }

    @Override
    public String toString() {
        return "SeguimientoSolicitud{" + "idSeguimientoSolicitud=" + idSeguimientoSolicitud + ", idSolicitud=" + idSolicitud + ", numeroTramite=" + numeroTramite + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", usuario=" + usuario + ", variables=" + variables + ", funcionTransferencia=" + funcionTransferencia + '}';
    }

}
