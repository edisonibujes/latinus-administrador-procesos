/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.admin.process.comun.persistencia.jpa.entidades;

import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "seguimiento_solicitud", schema = "public")
@NamedQueries({
    @NamedQuery(name = "SeguimientoSolicitud.findAll", query = "SELECT s FROM SeguimientoSolicitud s")})
public class SeguimientoSolicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguimiento_solicitud")
    private Integer idSeguimientoSolicitud;

    @JoinColumn(name = "id_solicitud", referencedColumnName = "id_solicitud")
    @ManyToOne
    private Solicitud idSolicitud;
    
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    @ManyToOne
    private Proceso idProceso;

    @Column(name = "numero_tramite")
    private Integer numeroTramite;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp fechaFin;

    @JoinColumn(name = "estado", referencedColumnName = "id_catalogo")
    @ManyToOne
    private Catalogo estado;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "variables")
    private String variables;

    @Column(name = "funcion_transferencia")
    private String funcionTransferencia;
    
    @JoinColumn(name = "formulario_actual", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario formularioActual;
    
    @JoinColumn(name = "formulario_siguiente", referencedColumnName = "id_formulario")
    @ManyToOne
    private Formulario formularioSiguiente;
    
    public SeguimientoSolicitud() {

    }

    public Integer getIdSeguimientoSolicitud() {
        return idSeguimientoSolicitud;
    }

    public void setIdSeguimientoSolicitud(Integer idSeguimientoSolicitud) {
        this.idSeguimientoSolicitud = idSeguimientoSolicitud;
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

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
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

    public Solicitud getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Solicitud idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Formulario getFormularioActual() {
        return formularioActual;
    }

    public void setFormularioActual(Formulario formularioActual) {
        this.formularioActual = formularioActual;
    }

    public Formulario getFormularioSiguiente() {
        return formularioSiguiente;
    }

    public void setFormularioSiguiente(Formulario formularioSiguiente) {
        this.formularioSiguiente = formularioSiguiente;
    }

    @Override
    public String toString() {
        return "SeguimientoSolicitud{" + "idSeguimientoSolicitud=" + idSeguimientoSolicitud + ", idSolicitud=" + idSolicitud + ", idProceso=" + idProceso + ", numeroTramite=" + numeroTramite + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estado=" + estado + ", usuario=" + usuario + ", variables=" + variables + ", funcionTransferencia=" + funcionTransferencia + ", formularioActual=" + formularioActual + ", formularioSiguiente=" + formularioSiguiente + '}';
    }
    
}
